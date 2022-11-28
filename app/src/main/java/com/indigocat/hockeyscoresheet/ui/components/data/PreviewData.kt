package com.indigocat.hockeyscoresheet.ui.components.data

import com.indigocat.hockeyscoresheet.data.api.model.Facility
import com.indigocat.hockeyscoresheet.data.api.model.Game
import com.indigocat.hockeyscoresheet.data.api.model.Goal
import com.indigocat.hockeyscoresheet.data.api.model.Infraction
import com.indigocat.hockeyscoresheet.data.api.model.Penalty
import com.indigocat.hockeyscoresheet.data.api.model.PenaltyType
import com.indigocat.hockeyscoresheet.data.api.model.Person
import com.indigocat.hockeyscoresheet.data.api.model.PlayType
import com.indigocat.hockeyscoresheet.data.api.model.Player
import com.indigocat.hockeyscoresheet.data.api.model.Shot
import com.indigocat.hockeyscoresheet.data.api.model.Team


val games = listOf(
    Game(
        "123",
        Team("1", "Colorado Avalanche", "Avalanche", Person("1", "Jared", "Bednar"), "Ball Arena"),
        Team("2", "Toronto Maple Leafs", "Maple Leafs", Person("1", "Sheldon", "Keefe"), "Scotiabank Arena"),
        Facility("123", "Ball Arena", "", "", "", ""),
        null, "2022-11-14:7:30Z+4"
    ),
    Game(
        "124",
        Team("3", "Calgary Flames", "Flames", Person("1", "Bryan", "Sutter"), "The Saddledome"),
        Team("1", "Colorado Avalanche", "Avalanche", Person("1", "Jared", "Bednar"), "Ball Arena"),
        Facility("123", "The Saddledome", "", "", "", ""),
        null, "2022-11-14:7:30Z+4", 3, 6
    ),
    Game(
        "125",
        Team("3", "Calgary Flames", "Flames", Person("1", "Bryan", "Sutter"), "The Saddledome"),
        Team("1", "Colorado Avalanche", "Avalanche", Person("1", "Jared", "Bednar"), "Ball Arena"),
        Facility("123", "The Saddledome", "", "", "", ""),
        null, "2022-11-14:7:30Z+4", 2, 1
    )
)
val goals = listOf(
    Goal("123", "123", "1", 1, 350,
        Player("123", "Mikko", "Rantannen", 96, "RW"),
        Player("1", "Jack", "Davila", 15, "C"), Player("2", "Nathan", "MacKinnon", 29, "C"),
        Player("123", "Simon", "Holstien", 33, "G"),
        PlayType.EvenStrength
    ),
    Goal("123", "123", "1", 1, 1000,
        Player("1", "Jack", "Davila", 15, "C"), Player("2", "Nathan", "MacKinnon", 29, "C"),
        null,
        Player("123", "Simon", "Holstien", 33, "G"),
        PlayType.PowerPlay
    ),
    Goal("123", "123", "2", 2, 850,
        Player("1", "Autson", "Matthews", 34, "C"), Player("2", "Alexander", "Kerfoot", 15, "C"),
        null,
        Player("123", "Alexandar", "Georgiev", 33, "G"),
        PlayType.EvenStrength
    ),
    Goal("123", "123", "1", 3, 1195,
        Player("1", "Jack", "Davila", 15, "C"), Player("2", "Nathan", "MacKinnon", 29, "C"),
        null,
        Player("123", "Simon", "Holstien", 33, "G"),
        PlayType.ShortHanded
    )
)

val shots = listOf(
    Shot("1", "123", "1", 1),
    Shot("1", "123", "1", 1),
    Shot("1", "123", "1", 1),
    Shot("1", "123", "1", 1),
    Shot("1", "123", "1", 1),
    Shot("1", "123", "1", 1),
    Shot("1", "123", "1", 1),
    Shot("1", "123", "1", 1),
    Shot("1", "123", "1", 1),
    Shot("1", "123", "1", 1),
    Shot("1", "123", "1", 1),
    Shot("1", "123", "2", 1),
    Shot("1", "123", "2", 1),
    Shot("1", "123", "2", 1),
    Shot("1", "123", "2", 1),
    Shot("1", "123", "2", 1),
    Shot("1", "123", "2", 1),
    Shot("1", "123", "2", 1),
    Shot("1", "123", "1", 2),
    Shot("1", "123", "1", 2),
    Shot("1", "123", "1", 2),
    Shot("1", "123", "1", 2),
    Shot("1", "123", "1", 2),
    Shot("1", "123", "1", 2),
    Shot("1", "123", "1", 2),
    Shot("1", "123", "1", 2),
    Shot("1", "123", "2", 2),
    Shot("1", "123", "2", 2),
    Shot("1", "123", "2", 2),
    Shot("1", "123", "2", 2),
    Shot("1", "123", "2", 2),
    Shot("1", "123", "2", 2),
    Shot("1", "123", "2", 2),
    Shot("1", "123", "2", 2),
    Shot("1", "123", "2", 2),
    Shot("1", "123", "2", 2),
    Shot("1", "123", "2", 2),
    Shot("1", "123", "1", 3),
    Shot("1", "123", "1", 3),
    Shot("1", "123", "1", 3),
    Shot("1", "123", "1", 3),
    Shot("1", "123", "1", 3),
    Shot("1", "123", "1", 3),
    Shot("1", "123", "2", 3),
    Shot("1", "123", "2", 3),
    Shot("1", "123", "2", 3)
)

val penalties = listOf(
    Penalty(
        "102", "103", 1, 400,
        Player("502", "Sam", "Adams", 5),
        PenaltyType.Minor,
        Infraction.Tripping
    )
)


val avalanche = Team(
    "1",
    "Colorado Avalanche",
    "Avalanche",
    Person("1", "Jared", "Bednar"),
    "Ball Arena",
    "https://www-league.nhlstatic.com/images/logos/teams-20222023-light/21.svg"

)

val mapleLeafs = Team(
    "2",
    "Toronto Maple Leafs",
    "Maple Leafs",
    Person("2", "Sheldon", "Keefe"),
"Scotiabank Arena",
    "https://www-league.nhlstatic.com/images/logos/teams-20222023-light/10.svg"
)

val avsRoster = listOf(
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

