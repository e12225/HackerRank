from datetime import datetime


# this function converts a given string to a datetime object
def read_datetime_input():
    date_time_object = datetime.strptime(input(), '%a %d %b %Y %H:%M:%S %z')
    return date_time_object


def main():
    number_of_test_cases = int(input())

    for t in range(number_of_test_cases):
        t1 = read_datetime_input()
        t2 = read_datetime_input()

        # here, the absolute difference is converted into seconds by total_seconds() function
        print(int(abs(t1 - t2).total_seconds()))


if __name__ == '__main__':
    main()
