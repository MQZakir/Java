# Word Unscrambler
### Video Demo: https://youtu.be/915XdqzoeP4
### Description:
A program to unscramble a combination of letters with vowels input by the user.

My video linked above has a short demo of the working program.

To make sure you run the program correctly, make sure you do it in your personal codespace by installing the kivy library and all the dependencies.

Kivy is a library used to make multiplatform apps. It is a solely OOP focused library so having to use it will require knowledge about OOP

#### Words Class:
    The Words class is present to access all the words of the dictionary stored in 'words.txt'. It then returns all of those words to Unscrambled class.

#### Unscrambled Class:
    This class is where the whole unscrambling process takes place, and it is a child class to the parent, Words class

    Firstly, in the __init__ function, it initializes the input which holds the users input, the sorted_words list to hold the words from the dictionary returned by Words class using super() function, indices variable to capture and store a list of the indices which we will talk about later, and the unscrambled_words list to hold all the words unscrabled which is then return to the GUI.

    There is then a getter function to return the unscrambled_words list

    Besdies that, the setter is where everything happens:
    1) It sorts the words letter by letter in both the dictionary(stored in
       sorted_words) and  from the user input.
    2) It then matches the sorted lists using the loop. It matches the lists
       where the sorted words match. As they are sorted, it will be easier to
       match the words what the user is trying to search with the unscrambled
       word.
    3) Then it stores the indices from sorted_words where match is found
    4) Then it finds the words at the indices. The indices of sorted_words
       and words lists is the same so it grabs the word by matching the indices.
    5) It appends all the words found into a dummy list called unword which is
       then used to initialize the value of unscrambled_word

#### kivy classes:
    The kivy classes mainly, MyGrid() and MyApp():

    MyGrid:
        This class is where the Gui comes into shape. It lays out the grid for
        the prompt, user input, the buttons to commence unscrambling or start a
        new word search, and the answers itself to be showcased below the buttons

        The __init__ function is the main part of this class as it initializes
        and displays the literal grids and widgets of the application

        The button1 function is called when, from the __init__ function, the
        unscrambutton is pressed. It initializes an object for using the
        Unscrambled class. It calls its setter by sending an empty string which
        later will be filled. It then performs the setter function and the
        value is return by initializing the instnace variable as the return
        value of the getter. It then displays the answers by creating another
        label to showcase below the buttons.

        The button2 function is called when the newwordbutton is clicked. It
        removes the label created for the answers using a special id (answer) so
        the view space is clear to output another answer.

    MyApp:
        This class's goal is to return the MyGrid class to the App class of the
        kivy.app library. Instead of having a main function, the kivy document-
        -ation suggests to just type down MyApp().run() toi activate the GUI.

#### Technology used:-
- VSCode IDE
- Laptop/Personal Workstation
- Java SDK
- GitBash as the compiler
- A bit of calming music on the side (helps alot)