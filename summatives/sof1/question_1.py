#!/usr/bin/python
# -*- coding: utf-8 -*-
def encrypt(message: str, shifts: list[int], alphabet: str):
    """Caeser cipher for message using individual letter shifts

    Args:
        message (str): [Message to be encrypted by cipher]
        shifts (list[int]): [Individual shifts to shift the message characters]
        alphabet (str): [Characters list to use shifts with]

    Raises:
        ValueError: [Not all characters in message in alphabet]
        ValueError: [Length of shift not equal to length of message]
        ValueError: [Shift is negative or longer than alphabet]

    Returns:
        result (str): [Shifted string]
    """
    result = ''
    for char in message:
        if char not in alphabet:
            raise ValueError
    if len(shifts) != len(message):
        raise ValueError
    for char in shifts:
        if char < 0 or char >= len(alphabet):
            raise ValueError  # out of range
    for i in range(len(message)):
        char_index = alphabet.index(message[i])
        to_shift = shifts[i]
        result_letter = char_index + to_shift
        if result_letter > len(alphabet) - 1:
            result_letter %= len(alphabet)  # the index is out of alphabet
        result += alphabet[result_letter]
    return result
