package io.fishingua.content.area

import io.fishingua.R.string
import io.fishingua.R.drawable
import io.fishingua.content.fish.*

object Kozintsa : Area(string.kozintsa_name, drawable.kozintsa, GoogleMapPosition(50.5139602,30.0381162),
    Pike, Crucian, Carp, Bream, Roach, Zander)
object KievReservoir : Area(string.Kiev_reservoir_name, drawable.kiev_reservoir, GoogleMapPosition(50.9319853,29.8549355),
    Catfish, Zander, Asp, Bream, Crucian, Tench, Perch)
object AmateurPond : Area(string.amateur_pond_name, drawable.amateur_pond, GoogleMapPosition(49.2640134,31.4209105),
    Carp, SilverCarp, Amur, Crucian, Roach, Tench, Pike, Perch, Ruff)