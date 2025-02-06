#La solucion tiene una complejidad de
#O(n log n)
#Esto debido a que la funcion sorted() de Python usa el Timsort
#que tiene esa complejidad
#No hay mas operaciones que aumenten drasticamente la complejidad de la funcion
def anagrama(pal1: str, pal2: str):
    pal1: str = pal1
    pal2: str = pal2

    return sorted(pal1) == sorted(pal2)

def test():
    palabra1_1 = "espada"
    palabra1_2 = "pesada"
    assert anagrama(palabra1_1, palabra1_2) == True
    palabra2_1 = "hola"
    palabra2_2 = "cola"
    assert anagrama(palabra2_1, palabra2_2) == False
    palabra3_1 = "amor"
    palabra3_2 = "roma"
    assert anagrama(palabra3_1, palabra3_2) == True
    print("Todo correcto")

def main():
    test()

if __name__ == "__main__":
    main()
