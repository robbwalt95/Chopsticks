

import prints

def idk(a,b,y,z,turn1):
    if a == 0 and b == 0:
        print("You win Player 2!")
    elif y == 0 and z == 0:
        print("You win Player1")
    else:
        if turn1 == True:
            print("\n-----------------------Play 1 - Your Turn-----------------------------")
            choice = str(input("Player1: Hit, Split, or Combine: "))
            while choice.upper() != "HIT" and choice.upper() != "SPLIT" and choice.upper() != "COMBINE": 
                choice = str(input("ERRROR -  Player1: Hit, Split, or Combine: "))
            if choice.upper() == "HIT":
                
                if a == 0:
                    select = "b"   
                elif b == 0:
                    select = "a"
                else:
                    select = (input("\nSelect Attacker Player 1: A or B: "))
                    while select.upper() != "A" and select.upper() != "B":
                        select = (input("\nERROR - Select Attacker Player 1: A or B: "))
    
                if y == 0:
                    hit = "z"
                elif z == 0:
                    hit = "y"
                else:
                    hit = (input("Hit Player 2: Y or Z: "))
                    while hit.upper() !=  "Y" and hit.upper() != "Z":
                        hit = (input("ERROR - Hit Player 2: Y or Z: "))
                
                if select.upper() == "A" and hit.upper() == "Y":
                    y += a
                elif select.upper() == "A" and hit.upper() == "Z":
                    z += a
                elif select.upper() == "B" and hit.upper() == "Y":
                    y += b
                else:
                    z += b
                    
            #Max 5 = 0STUDPID ERRRRROR
    
         
            turn1 = False
            
            
            
        else:
            print("\n---------------------Play 2 - Your Turn------------------------------")
            choice = str(input("Player2: Hit, Split, or Combine: "))
            while choice.upper() != "HIT" and choice.upper() != "SPLIT" and choice.upper() != "COMBINE": 
                choice = str(input("ERRROR -  Player2: Hit, Split, or Combine: "))
            if choice.upper() == "HIT":
                
                if y == 0:
                    select = "z"
                elif z == 0:
                    select = "y"
                else:
                    select = (input("\nSelect Attacker Player 2: Y or Z: "))
                    while select.upper() != "Y" and select.upper() != "Z":
                        select = (input("\nERROR - Select Attacker Player 2: Y or Z: "))
                    
                if a == 0:
                    hit = "b"
                elif b == 0:
                    hit = "a"
                else:
                    hit = (input("Hit Player 1: A or B: "))
                    while hit.upper() !=  "A" and hit.upper() != "B":
                        hit = (input("ERROR - Hit Player 1: A or B: "))
                    
                if select.upper() == "Y" and hit.upper() == "A":
                    a += y
                elif select.upper() == "Z" and hit.upper() == "A":
                    a += z
                elif select.upper() == "Y" and hit.upper() == "B":
                    b += y
                else:
                    b += z
            
     
            turn1 = True
        
        if a >= 5:
            a = 0
        if b >= 5:
            b = 0
        if y >= 5:
            y = 0
        if z >= 5:
            z = 0     
        prints.printGame(a,b,y,z, turn1)
         
    
    #if option == Split
    #split even or odd?
    
    #if choice.upper() == "COMBINE"
        #if turn1 == False #player 2
            #num = int(input(""))
    #certain
    #if x + y = 5+ then error



    