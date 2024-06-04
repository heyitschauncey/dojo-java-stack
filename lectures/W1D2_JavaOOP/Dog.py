class Dog:
    def __init__(self, name, age, hair_color):
        self.name = name
        self.age = age
        self.hair_color = hair_color

    @classmethod
    def getAllDogs():
        pass

    def doSomething(): 
        pass


d1 = Dog()

d1.doSomething()

Dog.getAllDogs()