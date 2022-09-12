package com.indigocat.hockeyscoresheet

import com.indigocat.hockeyscoresheet.data.model.Facility
import com.indigocat.hockeyscoresheet.data.model.Person
import com.indigocat.hockeyscoresheet.data.model.Player
import com.indigocat.hockeyscoresheet.data.model.Position

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
            Position.FORWARD
        ),
        Player(
            "123-126-111",
            "Andrew",
            "Cogliano",
            11,
            Position.FORWARD
        ),
        Player(
            "123-126-112",
            "J.T.",
            "Compher",
            37,
            Position.FORWARD
        ),
        Player(
            "123-126-113",
            "Darren",
            "Helm",
            43,
            Position.FORWARD
        ),
        Player(
            "123-126-114",
            "Charles",
            "Hudon",
            54,
            Position.FORWARD
        ),
        Player(
            "123-126-115",
            "Gabriel",
            "Landeskog",
            92,
            Position.FORWARD
        ),
        Player(
            "123-126-116",
            "Artturi",
            "Lehkonen",
            62,
            Position.FORWARD
        ),
        Player(
            "123-126-117",
            "Nathan",
            "Mackinnon",
            29,
            Position.FORWARD
        ),
        Player(
            "123-126-118",
            "Alex",
            "Newhook",
            18,
            Position.FORWARD
        ),
        Player(
            "123-126-119",
            "Valeri",
            "Nichuskin",
            13,
            Position.FORWARD
        ),
        Player(
            "123-126-120",
            "Logan",
            "O'Connor",
            25,
            Position.FORWARD
        ),
        Player(
            "123-126-1210",
            "Lucas",
            "Sedlak",
            45,
            Position.FORWARD
        ),
        Player(
            "123-126-122",
            "Mikko",
            "Rantanen",
            96,
            Position.FORWARD
        ),
        Player(
            "123-126-123",
            "Spencer",
            "Smallman",
            75,
            Position.FORWARD
        ),
        Player(
            "123-126-124",
            "Bowem",
            "Byram",
            4,
            Position.DEFENCE
        ),
        Player(
            "123-126-124",
            "Samuel",
            "Girard",
            49,
            Position.DEFENCE
        ),
        Player(
            "123-126-125",
            "Brad",
            "Hunt",
            77,
            Position.DEFENCE
        ),
        Player(
            "123-126-126",
            "Devon",
            "Toews",
            7,
            Position.DEFENCE
        ),
        Player(
            "123-126-127",
            "Erik",
            "Johnson",
            6,
            Position.DEFENCE
        ),
        Player(
            "123-126-128",
            "Kurtis",
            "MacDermid",
            56,
            Position.DEFENCE
        ),
        Player(
            "123-126-129",
            "Cale",
            "Makar",
            8,
            Position.DEFENCE
        ),
        Player(
            "123-126-130",
            "Josh",
            "Manson",
            42,
            Position.DEFENCE
        ),
        Player(
            "123-126-101",
            "Pavel",
            "Francouz",
            39,
            Position.GOALIE
        ),
        Player(
            "123-126-102",
            "Alexandar",
            "Georgiev",
            40,
            Position.GOALIE
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