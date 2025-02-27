class Student:
    def __init__(self, name: str, last_name: str):
        self.name = name
        self.last_name = last_name

    def __hash__(self):
        return hash(str(self.name+self.last_name))

    def __eq__(self, other):
        if not isinstance(other, Student):
            return NotImplemented
        print(self.name == other.name and self.last_name == other.last_name)
        return self.name == other.name and self.last_name == other.last_name

    def __str__(self):
        return f"{self.name} {self.last_name}"

"""
La complejidad del algoritmo es O(1)
Esto debido a que nunca se utilizan solamente llaves para acceder al elemento
Se usa un atributo llamado students_last_names para registrar todos los last_names ingresados y que cuando
se quiera reemplazar algun valor solo se busca si el last_name existe, si si, se busca el objeto dentro del
mapa students y se reemplaza todo el objeto, ya que es su 'llave primaria'
"""
class Department:
    def __init__(self, students: dict[Student, int]):
        self.students = students
        self.students_last_names: dict[str, str] = dict()

    def print_each(self):
        for student, mark in self.students.items():
            print(f"Student: {student}, Mark:  {mark}")

    def add_student(self, new_student: Student, mark):
        if new_student.last_name in self.students_last_names:
            #Se reemplaza el registro
            #Primero se arma al objeto de estudiante
            old_student = Student(self.students_last_names[new_student.last_name], new_student.last_name)
            del self.students[old_student]

            self.students[new_student] = mark
            self.students_last_names[new_student.last_name] = new_student.name
        else:
            #Se crea un nuevo registro
            self.students[new_student] = mark
            self.students_last_names[new_student.last_name] = new_student.name
