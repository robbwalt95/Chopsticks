import start

def menu():
    print("\nwelcome to the Home Screen")
    print("Palm Wars")
    try:
        input("Press enter to continue")
    except SyntaxError:
        pass
    start.Startgame()