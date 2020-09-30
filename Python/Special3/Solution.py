import re

number_of_credit_cards = input()

for credit_card in range(int(number_of_credit_cards)):

    card = input()

    # checking if it starts with 4,5 0r 6 and have 15 remaining digits
    valid_case_1 = bool(re.match(r"^[456]\d{15}$", card))

    # checking if it starts with 4,5 0r 6 and have digits in groups of 4 separated by one hyphen "-"
    valid_case_2 = bool(re.match(r"^[456]\d{3}\-\d{4}\-\d{4}\-\d{4}$", card))

    # getting rid of hyphens, for the convenience
    card = card.replace("-", "")

    # checking if it has at least 4 consecutive repeated digits
    valid_case_3 = bool(re.match(r"(?!.*(\d)(-?\1){3})", card))

    if (valid_case_1 or valid_case_2) and valid_case_3:
        print("Valid")
    else:
        print("Invalid")
