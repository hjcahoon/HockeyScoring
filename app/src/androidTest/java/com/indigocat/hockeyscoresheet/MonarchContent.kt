package com.indigocat.hockeyscoresheet

import com.indigocat.hockeyscoresheet.data.api.model.Facility
import com.indigocat.hockeyscoresheet.data.api.model.Person
import com.indigocat.hockeyscoresheet.data.api.model.Player
import com.indigocat.hockeyscoresheet.data.api.model.Position

object MonarchContent {

    val headCoach = Person(
        "123-125-458",
        "Jimmy",
        "Dexter",
        "jimmy.dexter@mohi.com",
        null
    )

    val assistantCoaches = listOf(
        Person(
            "123-125-459",
            "Steve",
            "Strunk"
        ),
        Person(
            "123-125-460",
            "Hogan",
            "Jones"
        )
    )

    val goalies = listOf<Player>(
        Player(
            "123-125-100",
            "Simon",
            "Holstien",
            29,
             Position.GOALIE
        ),
        Player(
            "123-125-101",
            "Josh",
            "Ringeon",
            33,
            Position.GOALIE
        )
    )

    val players = listOf(
        Player(
            "123-125-110",
            "Hudsin",
            "DenHartog",
            2,
            Position.DEFENCE
        ),
        Player(
            "123-125-111",
            "Trey",
            "Chance",
            3,
            Position.FORWARD
        ),
        Player(
            "123-125-112",
            "Marty",
            "Swail",
            4,
            Position.DEFENCE
        ),
        Player(
            "123-125-113",
            "Branden",
            "DeSouza-Chen",
            5,
            Position.FORWARD
        ),
        Player(
            "123-125-114",
            "Chase",
            "Saal",
            7,
            Position.DEFENCE
        ),
        Player(
            "123-125-115",
            "Issac",
            "MansField",
            8,
            Position.FORWARD
        ),
        Player(
            "123-125-116",
            "Reid",
            "Taylor",
            9,
            Position.FORWARD
        ),
        Player(
            "123-125-117",
            "Vincent",
            "Felt",
            10,
            Position.FORWARD
        ),
        Player(
            "123-125-118",
            "Jackson",
            "Brotski",
            11,
            Position.FORWARD
        ),
        Player(
            "123-125-119",
            "Simon",
            "Chan",
            12,
            Position.FORWARD
        ),
        Player(
            "123-125-120",
            "Jesper",
            "Olofsson",
            13,
            Position.DEFENCE
        ),
        Player(
            "123-125-121",
            "Jack",
            "Davila",
            15,
            Position.FORWARD
        ),
        Player(
            "123-125-122",
            "Julian",
            "Zerwekh Reardon",
            16,
            Position.FORWARD
        ),
        Player(
            "123-125-123",
            "Gavin",
            "Rowan",
            18,
            Position.FORWARD
        ),
        Player(
            "123-125-124",
            "Blake",
            "Freeze",
            19,
            Position.FORWARD
        ),
        Player(
            "123-125-125",
            "Ben",
            "Wiener",
            20,
            Position.FORWARD
        ),
        Player(
            "123-125-126",
            "Holden",
            "Lindgren",
            55,
            Position.FORWARD
        ),
        Player(
            "123-125-127",
            "Devin",
            "Cahoon",
            24,
            Position.DEFENCE
        ),
        Player(
            "123-125-100",
            "Simon",
            "Holstien",
            29,
            Position.GOALIE
        ),
        Player(
            "123-125-101",
            "Josh",
            "Ringeon",
            33,
            Position.GOALIE
        )
    )

    val sportStable = Facility(
        "1",
        "Sport Stable",
        "1 Superior Drive",
        "Superior",
        "Colorado",
        "80027",
        listOf("East", "West")
    )



}
