"""
El algoritmo tiene una complejidad de O(n)
Esto debido a que aunque es recursiva, la cantidad de elementos a procesar no aumenta con cada recursion
Los elementos de la lista son recorridos linealmente
La funcion extend() evita recorrer los dos arrays para crear el array combinado, simplificando la complejidad resultante
"""
def transform_array(complex_array):
    empty_array = []
    for element in complex_array:
        #Comprueba si el elemento actual es un arreglo
        if isinstance(element, list):
            #empty_array = empty_array + transform_array(element)
            """Se usa el metodo extend en lugar del operador + ya que esto implica crear un array recorriendo
            el array existente y el array nuevo dando como complejidad n^2, esto lo simplifica a n"""
            empty_array.extend(transform_array(element))
        else:
            empty_array.append(element)
    return empty_array


def test_1():
    print("Test 1...")

    assert transform_array([1,2,["3","4"]]) == [1,2,"3","4"]

    print("Exito")
    print("======================")

def test_2():
    print("Test 2...")

    assert transform_array([1,2,[3,4,[5,6]]]) == [1,2,3,4,5,6]

    print("Exito")
    print("======================")

def test_3():
    print("Test 3...")

    assert transform_array([1,2,["a","b",[5,6]]]) == [1,2,"a","b",5,6]

    print("Exito")
    print("======================")

def test_4():
    print("Test 4...")

    assert transform_array([1,2,[3,4,[5,6,[7,8,[9,10]]]]]) == [1,2,3,4,5,6,7,8,9,10]

    print("Exito")
    print("======================")

def test_5():
    print("Test 5...")

    assert transform_array([1,2,[3,4,[5,6,[7,8,[9,10,[11,12],13]]]]]) == [1,2,3,4,5,6,7,8,9,10,11,12,13]

    print("Exito")
    print("======================")

def test_6():
    print("Test 6...")

    assert transform_array([1,2,[3,[4,5,[6,7],8,9],10],11]) == [1,2,3,4,5,6,7,8,9,10,11]

    print("Exito")
    print("======================")

def main():
    test_1()
    test_2()
    test_3()
    test_4()
    test_5()
    test_6()
    print("======================")
    print("Todos los test pasados")


if __name__ == "__main__":
    main()
