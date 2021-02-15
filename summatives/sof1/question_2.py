#!/usr/bin/python
# -*- coding: utf-8 -*-
import re
import string


def molecule_to_list(molecule):
    tmp = ''
    tmp2 = []
    out = []
    molecules = []
    molecules_v2 = ''
    for i in molecule:
        if i.lower() not in string.ascii_lowercase and not i.isdigit():
            raise ValueError  # checks all characters are valid
    if not molecule[0].isupper():
        raise ValueError  # molecule starts with uppercase

    for (i, v) in enumerate(molecule):
        if i + 1 != len(molecule):
            print v
            if v.isupper() and molecule[i + 1].isupper():
                molecules_v2 += v + '1'
            elif v.islower() and molecule[i + 1].isupper():
                molecules_v2 += v + '1'
            else:
                molecules_v2 += v
        else:
            if not molecule[-1].isdigit():
                molecules_v2 += v + '1'
            else:
                molecules_v2 += molecule[-1]

    for (i, v) in enumerate(molecules_v2):
        if v.isdigit():
            tmp += v
            if i + 1 >= len(molecules_v2):
                out.append(tmp)
            else:
                if molecules_v2[i + 1].isdigit():
                    pass
                else:
                    out.append(tmp)
                    tmp = ''
        else:
            tmp += v
    r = re.compile('([a-zA-Z]+)([0-9]+)')
    new = []
    tuples = [r.match(string).groups() for string in out]
    # line above converts our list of molecules to tuples
    for i in tuples:
        new.append((i[0], int(i[1])))
    for i in new:
        if i[0].islower():
            raise ValueError
    return new
