# сaesar сipher cli

simple java cli project for working with caesar cipher.

this is a small study project to practice basic java concepts.

## features

- text encryption
- decryption with a key
- brute force decryption (with simple scoring)
- works with files (input/output)
- basic validation and error handling
- small kawaii-style console ui

## how it works

the program reads text from a file, applies the selected mode, and writes the result to a new file.

## how to run

run the project from IntelliJ IDEA (MainApp).

## project structure

- `config` — alphabet, modes, scoring rules  
- `service` — cipher logic, brute force, file operations  
- `validator` — input validation  
- `exception` — custom exceptions  
- `util` — console output helper 
- `model` — data models (brute force result)

## notes

this project focuses on practicing basic java syntax and core concepts, including:
- control flow (loops and conditions)
- strings
- collections (maps)
- basic program structure
- exception handling
- file i/o
- simple project structure (separation into packages)
