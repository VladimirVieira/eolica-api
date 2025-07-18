import csv
import time  # Importa o módulo para medir tempo
class Grafo:
    def __init__(self, vertices):
        self.total_vertices = vertices
        self.arestas = []

    def adicionar_aresta(self, origem, destino, capacidade):
        self.arestas.append([origem, destino, capacidade])

    def busca_profundidade(self, origem, destino, fluxo, visitado):
        visitado[origem] = True
        if origem == destino:
            return fluxo
        for aresta in self.arestas:
            u, v, capacidade = aresta
            if u == origem and not visitado[v] and capacidade > 0:
                fluxo_atual = min(fluxo, capacidade)
                fluxo_temporario = self.busca_profundidade(v, destino, fluxo_atual, visitado)
                if fluxo_temporario > 0:
                    aresta[2] -= fluxo_temporario
                    self.adicionar_aresta(v, u, fluxo_temporario)
                    return fluxo_temporario
        return 0

    def ford_fulkerson(self, origem, destino):
        fluxo_maximo = 0
        while True:
            visitado = [False] * self.total_vertices
            fluxo = self.busca_profundidade(origem, destino, float('Inf'), visitado)
            if fluxo == 0:
                break
            fluxo_maximo += fluxo
        return fluxo_maximo

    def obter_arestas(self):
        return self.arestas.copy()


def ler_arquivo_tsv(nome_arquivo):
    mapa_ids = {}  # mapeia o nome da proteína para um índice
    arestas = []
    indice_atual = 0

    with open(nome_arquivo, newline='', encoding='utf-8') as arquivo:
        leitor = csv.DictReader(arquivo, delimiter='\t')
        for linha in leitor:
            proteina1 = linha['#node1']
            proteina2 = linha['node2']
            pontuacao = float(linha['combined_score'])

            if proteina1 not in mapa_ids:
                mapa_ids[proteina1] = indice_atual
                indice_atual += 1
            if proteina2 not in mapa_ids:
                mapa_ids[proteina2] = indice_atual
                indice_atual += 1

            u = mapa_ids[proteina1]
            v = mapa_ids[proteina2]
            arestas.append((u, v, pontuacao))

    return mapa_ids, arestas


def principal():
    print("=== FORD-FULKERSON EM REDE DE PROTEÍNAS ===")
    nome_arquivo = input("Digite o nome do arquivo TSV da rede (ex: string_interactions(1).tsv): ").strip()

    try:
        mapa_ids, arestas = ler_arquivo_tsv(nome_arquivo)
    except FileNotFoundError:
        print("Arquivo não encontrado. Finalizando.")
        return

    total_vertices = len(mapa_ids)
    grafo = Grafo(total_vertices)
    for origem, destino, capacidade in arestas:
        grafo.adicionar_aresta(origem, destino, capacidade)

    print(f"\nForam carregadas {total_vertices} proteínas e {len(arestas)} interações.")
    print("Proteínas disponíveis:")
    for nome, indice in list(mapa_ids.items())[:17]:
        print(f"{indice}: {nome}")

    proteina_origem = input("Digite o nome da proteína de ORIGEM: ").strip()
    proteina_destino = input("Digite o nome da proteína de DESTINO: ").strip()

    if proteina_origem not in mapa_ids or proteina_destino not in mapa_ids:
        print("Proteína de origem ou destino não encontrada na rede. Finalizando.")
        return

    # Início da medição do tempo
    inicio = time.time()
    fluxo_maximo = grafo.ford_fulkerson(proteina_origem, proteina_destino)
    fim = time.time()
    tempo_execucao = fim - inicio

    print(f"\nFluxo máximo entre {proteina_origem} e {proteina_destino}: {fluxo_maximo}")

    nome_saida = f"relatorio_fluxo_{proteina_origem}_para_{proteina_destino}.txt"
    with open(nome_saida, "w") as arquivo:
        arquivo.write("Relatório de fluxo máximo na rede de proteínas\n")
        arquivo.write(f"Arquivo utilizado: {nome_arquivo}\n")
        arquivo.write(f"Origem: {proteina_origem} (índice {indice_origem})\n")
        arquivo.write(f"Destino: {proteina_destino} (índice {indice_destino})\n")
        arquivo.write(f"Fluxo máximo: {fluxo_maximo}\n\n")
        arquivo.write(f"Tempo de execução: {tempo_execucao:.4f} segundos\n\n")
      
        arquivo.write("Interações carregadas:\n")
        for origem, destino, capacidade in arestas:
            nome_origem = [k for k, v in mapa_ids.items() if v == origem][0]
            nome_destino = [k for k, v in mapa_ids.items() if v == destino][0]
            arquivo.write(f"{nome_origem} -> {nome_destino} : capacidade = {capacidade}\n")

    print(f"Relatório salvo em '{nome_saida}'.")


if __name__ == "__main__":
    principal()


