
nome_arquivo_entrada = 'slots_dump.dat'
nome_arquivo_saida = 'slots_dump_mod.dat'

numeros_modificados = []

with open(nome_arquivo_entrada, 'r') as arquivo_entrada:
    for linha in arquivo_entrada:
        try:
            numero = int(linha.strip())
            
            numeros_modificados.append(numero + 2500)
        except ValueError:
            pass

with open(nome_arquivo_saida, 'w') as arquivo_saida:
    for numero_modificado in numeros_modificados:
        arquivo_saida.write(f'{numero_modificado}\n')