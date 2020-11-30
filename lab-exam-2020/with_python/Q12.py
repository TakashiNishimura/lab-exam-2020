from typing import List
from numpy.random import *


def generate_10_numbers_from_0_until_100() -> List[int]:
    list = []
    for i in range(10):
        list.append(randint(0, 99))
    return list

def print_list(numbers: List[int]):
    for n in numbers:
        print(n)

def sort_in_ascending_order(numbers: List[int]) -> List[int]:
    return sorted(numbers)


def remove_content_which_number_is_under_50(numbers: List[int]) -> List[int]:
    return [n for n in numbers if n > 50]


if __name__ == '__main__':
    rand_list = generate_10_numbers_from_0_until_100()
    print("乱数10コ")
    print_list(rand_list)
    print("\n昇順ソート")
    print_list(sort_in_ascending_order(rand_list))
    print("\n50以下削除")
    print(remove_content_which_number_is_under_50(rand_list))