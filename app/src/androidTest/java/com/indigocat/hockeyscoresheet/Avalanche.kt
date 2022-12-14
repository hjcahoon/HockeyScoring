package com.indigocat.hockeyscoresheet

import com.indigocat.hockeyscoresheet.data.api.model.Facility
import com.indigocat.hockeyscoresheet.data.api.model.Person
import com.indigocat.hockeyscoresheet.data.api.model.Player

object Avalanche {
    val headCoach = Person(
        "123-126-1236",
        "Jared",
        "Bednar"
    )
    val assistantCoaches = listOf(
        Person(
            "123-126-1237",
            "Ray",
        "Bennet"
        ),
        Person(
            "123-126-1238",
            "Nolan",
            "Pratt"
        )
    )

    val players = listOf(
        Player(
            "123-126-110",
            "Anton",
            "Blidh",
            81,
            "LW"
        ),
        Player(
            "123-126-111",
            "Andrew",
            "Cogliano",
            11,
            "RW"
        ),
        Player(
            "123-126-112",
            "J.T.",
            "Compher",
            37,
            "C"
        ),
        Player(
            "123-126-113",
            "Darren",
            "Helm",
            43,
            "D"
        ),
        Player(
            "123-126-114",
            "Charles",
            "Hudon",
            54,
            "RW"
        ),
        Player(
            "123-126-115",
            "Gabriel",
            "Landeskog",
            92,
            "RW"
        ),
        Player(
            "123-126-116",
            "Artturi",
            "Lehkonen",
            62,
            "LW"
        ),
        Player(
            "123-126-117",
            "Nathan",
            "Mackinnon",
            29,
            "C"
        ),
        Player(
            "123-126-118",
            "Alex",
            "Newhook",
            18,
            "RW"
        ),
        Player(
            "123-126-119",
            "Valeri",
            "Nichuskin",
            13,
            "LW"
        ),
        Player(
            "123-126-120",
            "Logan",
            "O'Connor",
            25,
            "C"
        ),
        Player(
            "123-126-1210",
            "Lucas",
            "Sedlak",
            45,
            "RW"
        ),
        Player(
            "123-126-122",
            "Mikko",
            "Rantanen",
            96,
            "RW"
        ),
        Player(
            "123-126-123",
            "Spencer",
            "Smallman",
            75,
            "LW"
        ),
        Player(
            "123-126-124",
            "Bowem",
            "Byram",
            4,
            "D"
        ),
        Player(
            "123-126-124",
            "Samuel",
            "Girard",
            49,
            "D"
        ),
        Player(
            "123-126-125",
            "Brad",
            "Hunt",
            77,
            "D"
        ),
        Player(
            "123-126-126",
            "Devon",
            "Toews",
            7,
            "D"
        ),
        Player(
            "123-126-127",
            "Erik",
            "Johnson",
            6,
            "D"
        ),
        Player(
            "123-126-128",
            "Kurtis",
            "MacDermid",
            56,
            "D"
        ),
        Player(
            "123-126-129",
            "Cale",
            "Makar",
            8,
            "D"
        ),
        Player(
            "123-126-130",
            "Josh",
            "Manson",
            42,
            "D"
        ),
        Player(
            "123-126-101",
            "Pavel",
            "Francouz",
            39,
            "G"
        ),
        Player(
            "123-126-102",
            "Alexandar",
            "Georgiev",
            40,
            "G"
        )
    )

    val facility = Facility(
        "3",
        "Ball Arena",
        "1000 Chopper Circle",
        "Denver",
        "Colorado",
        "80204"
    )
}
