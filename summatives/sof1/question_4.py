#!/usr/bin/python
# -*- coding: utf-8 -*-


def check_level(level):
    if level[0] == 0:
        return False  # make sure first value isnt a 0

    def check_level_inner(level):
        print level
        try:
            if not len(level) > 1:
                if level[0] == 0:
                    return False  # check last value
            for (i, v) in enumerate(level):
                if not i + 1 >= len(level):
                    if v == 1 and level[i + 1] == 0:  # cant make jump
                        return False
        except:
            return True
        return check_level_inner(level[1:])  # recursion magic

    return check_level_inner(level)
