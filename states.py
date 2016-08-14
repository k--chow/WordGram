class State(object):
    def __init__(self, word, probability):
        self.word = word
        self.probability = probability
    
    def word(self):
        return self.word

s = State("hello", 0.5)
print(s.word)


        
