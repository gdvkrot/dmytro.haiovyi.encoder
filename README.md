# dmytro.haiovyi.encoder
dmytro.haiovyi.encoder

The program works with files from project resources.
You need to place the file in the desired directory and then specify it as an input parameter for the algorithm.

The program can run either through command-line arguments or by reading parameters from the console (the prompts will be obvious).
When working with console parameters, the order of parameters is as follows:
  - String fileName
  - String inputMode (ENCRYPT, DECRYPT, BRUTE_FORCE - not implemented)
  - String inputLanguage (ENGLISH, RUSSIAN, UKRAINIAN - worked with some issues)
  - String inputKey (Integer value only - int)

File renaming is not implemented. The program overwrites files in resources.
