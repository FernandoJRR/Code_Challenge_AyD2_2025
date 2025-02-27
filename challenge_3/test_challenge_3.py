import unittest

from src_challenge_3 import *

class TestChallenge3(unittest.TestCase):
    def test_add_students_not_equal(self):
        departamento1 = Department(dict())
        departamento1.add_student(Student("Marco", "Lopez"), 5)
        departamento1.print_each()
        departamento1.add_student(Student("Maria", "Prado"), 9)
        departamento1.print_each()

        test_dict = dict()
        test_dict[Student("Marco", "Lopez")] = 5
        test_dict[Student("Maria", "Prado")] = 9

        self.assertEqual(departamento1.students, test_dict)

    def test_add_students_equal(self):
        test_dict = dict()
        test_dict[Student("Adrian", "Lopez")] = 9

        departamento2 = Department(dict())
        departamento2.add_student(Student("Juan", "Lopez"), 5)
        departamento2.add_student(Student("Adrian", "Lopez"), 9)

        self.assertEqual(departamento2.students, test_dict)


if __name__ == "__main__":
    unittest.main()
