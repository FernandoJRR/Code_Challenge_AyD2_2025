def anagrama(pal1, pal2):
    pal1 = pal1.replace(" ", "").lower()
    pal2 = pal2.replace(" ", "").lower()

    return sorted(pal1) == sorted(pal2)

def main():
    palabra1 = input("Primer palabra:")
    palabra2 = input("Segunda palabra:")
    resultado = anagrama(palabra1, palabra2)
    print(resultado)


if __name__ == "__main__":
    main()
