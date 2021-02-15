#!/usr/bin/python
# -*- coding: utf-8 -*-
ATOMS = {
    'H': {'name': 'Hydrogen', 'weight': 1.00797},
    'He': {'name': 'Helium', 'weight': 4.00260},
    'C': {'name': 'Carbon', 'weight': 12.011},
    'N': {'name': 'Nitrogen', 'weight': 14.0067},
    'O': {'name': 'Oxygen', 'weight': 15.9994},
    'Ca': {'name': 'Calium', 'weight': 40.08},
    }


def molar_mass(molecule):
    out = 0
    for i in molecule:
        if i[0] not in ATOMS.keys():
            raise ValueError  # molecule isnt in our dict
        toget = ATOMS[i[0]]
        amount = i[1]
        out += toget['weight'] * amount  # add to total weight
    return out
