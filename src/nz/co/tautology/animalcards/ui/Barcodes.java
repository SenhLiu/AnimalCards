package nz.co.tautology.animalcards.ui;

import java.util.Hashtable;
import nz.co.tautology.animalcards.R;

public final class Barcodes {
    private static int[] _picureIds = new int[] { 
            R.drawable.blackmamba,
            R.drawable.cheetah,
            R.drawable.brownhare,
            R.drawable.africanlion,
            R.drawable.peregrinefalcon,
            R.drawable.mantisshrimp,
            R.drawable.springbok,
            R.drawable.whitethroatedneedletail,
            R.drawable.dragonfly,
            R.drawable.bluewildebeest,
            R.drawable.freetailedbat,
            R.drawable.warthog,
            R.drawable.africanbuffalo,
            R.drawable.honeybadger,
            R.drawable.greateronehornedrhinoceros,
            R.drawable.emperorpenguin,
            R.drawable.bandedmongoose,
            R.drawable.bartailedgodwit,
            R.drawable.koala,
            R.drawable.bactriancamel,
            R.drawable.borealchorusfrog,
            R.drawable.monarchbutterfly,
            R.drawable.pronghorn,
            R.drawable.blackwoodpecker,
            R.drawable.prairierattlesnake,
            R.drawable.leopardseal,
            R.drawable.southerncorroboreefrog,
            R.drawable.borneanslowloris,
            R.drawable.oystertoadfish,
            R.drawable.sawscaledviper,
            R.drawable.strawberrypoisonfrog,
            R.drawable.saltwatercrocodile,
            R.drawable.southerncassowary,
            R.drawable.commonhippopotamus,
            R.drawable.anophelesmosquito,
            R.drawable.africanwilddog,
            R.drawable.borneanorangutan,
            R.drawable.woodpeckerfinch,
            R.drawable.greentreefrog,
            R.drawable.brownrat,
            R.drawable.newcaledoniancrow,
            R.drawable.seaotter,
            R.drawable.americanalligator,
            R.drawable.egyptianvulture,
            R.drawable.chipmunk,
            R.drawable.acornwoodpecker,
            R.drawable.chimpanzee,
            R.drawable.americanbeaver,
            R.drawable.grizzlybear,
            R.drawable.tasmaniandevil,
            R.drawable.killerwhale,
            R.drawable.bengaltiger,
            R.drawable.komododragon,
            R.drawable.fossa,
            R.drawable.monkeyeatingeagle,
            R.drawable.europeanwolf,
            R.drawable.polarbear,
            R.drawable.spottedhyena,
            R.drawable.africanizedhoneybee,
            R.drawable.wolverine,
            R.drawable.babirusa,
            R.drawable.shoebillstork,
            R.drawable.streakedtenrec,
            R.drawable.easterntubenosedbat,
            R.drawable.pygmythreetoedsloth,
            R.drawable.proboscismonkey,
            R.drawable.ninebandedarmadillo,
            R.drawable.narwhal,
            R.drawable.maraboustork,
            R.drawable.turtlefrog,
            R.drawable.southernelephantseal,
            R.drawable.saigaantelope,
            R.drawable.greenheron,
            R.drawable.gaboonviper,
            R.drawable.asiankoel,
            R.drawable.snowleopard,
            R.drawable.tawnyfrogmouth,
            R.drawable.cloudedleopard,
            R.drawable.magnificentfrigatebird,
            R.drawable.tokaygecko,
            R.drawable.malaysianhornedfrog,
            R.drawable.alligatorsnappingturtle,
            R.drawable.cuckoobee,
            R.drawable.barnowl,
            R.drawable.blackandgoldhowlermonkey,
            R.drawable.asianelephant,
            R.drawable.hyacinthmacaw,
            R.drawable.bladdercicada,
            R.drawable.siamang,
            R.drawable.powersawcricket,
            R.drawable.coquifrog,
            R.drawable.weddellseal,
            R.drawable.waterboatman,
            R.drawable.oilbird,
            R.drawable.northatlanticrightwhale,
            R.drawable.tigerpistolshrimp,
            R.drawable.whoopingcrane,
            R.drawable.mandrill,
            R.drawable.northamericanelk,
            R.drawable.blacktailedtrainbearer,
            R.drawable.westernlowlandgorilla,
            R.drawable.bluepeafowl,
            R.drawable.redcappedmanakin,
            R.drawable.bluebirdofparadise,
            R.drawable.capercaillie,
            R.drawable.ringtailedlemur,
            R.drawable.commonteal,
            R.drawable.costaricantreefrog
            };

    private static int[] _textIds = new int[] { 
            R.raw.blackmamba_html,
            R.raw.cheetah_html,
            R.raw.brownhare_html,
            R.raw.africanlion_html, 
            R.raw.peregrinefalcon_html, 
            R.raw.mantisshrimp_html, 
            R.raw.springbok_html,
            R.raw.whitethroatedneedletail_html,
            R.raw.dragonfly_html,
            R.raw.bluewildebeest_html,
            R.raw.freetailedbat_html,
            R.raw.warthog_html,
            R.raw.africanbuffalo_html,
            R.raw.honeybadger_html,
            R.raw.greateronehornedrhinoceros_html,
            R.raw.emperorpenguin_html,
            R.raw.bandedmongoose_html,
            R.raw.bartailedgodwit_html,
            R.raw.koala_html,
            R.raw.bactriancamel_html,
            R.raw.borealchorusfrog_html,
            R.raw.monarchbutterfly_html,
            R.raw.pronghorn_html,
            R.raw.blackwoodpecker_html,
            R.raw.prairierattlesnake_html,
            R.raw.leopardseal_html,
            R.raw.southerncorroboreefrog_html,
            R.raw.borneanslowloris_html,
            R.raw.oystertoadfish_html,
            R.raw.sawscaledviper_html,
            R.raw.strawberrypoisonfrog_html,
            R.raw.saltwatercrocodile_html,
            R.raw.southerncassowary_html,
            R.raw.commonhippopotamus_html,
            R.raw.anophelesmosquito_html,
            R.raw.africanwilddog_html,
            R.raw.borneanorangutan_html,
            R.raw.woodpeckerfinch_html,
            R.raw.greentreefrog_html,
            R.raw.brownrat_html,
            R.raw.newcaledoniancrow_html,
            R.raw.seaotter_html,
            R.raw.americanalligator_html,
            R.raw.egyptianvulture_html,
            R.raw.chipmunk_html,
            R.raw.acornwoodpecker_html,
            R.raw.chimpanzee_html,
            R.raw.americanbeaver_html,
            R.raw.grizzlybear_html,
            R.raw.tasmaniandevil_html,
            R.raw.killerwhale_html,
            R.raw.bengaltiger_html,
            R.raw.komododragon_html,
            R.raw.fossa_html,
            R.raw.monkeyeatingeagle_html,
            R.raw.europeanwolf_html,
            R.raw.polarbear_html,
            R.raw.spottedhyena_html,
            R.raw.africanizedhoneybee_html,
            R.raw.wolverine_html,
            R.raw.babirusa_html,
            R.raw.shoebillstork_html,
            R.raw.streakedtenrec_html,
            R.raw.easterntubenosedbat_html,
            R.raw.pygmythreetoedsloth_html,
            R.raw.proboscismonkey_html,
            R.raw.ninebandedarmadillo_html,
            R.raw.narwhal_html,
            R.raw.maraboustork_html,
            R.raw.turtlefrog_html,
            R.raw.southernelephantseal_html,
            R.raw.saigaantelope_html,
            R.raw.greenheron_html,
            R.raw.gaboonviper_html,
            R.raw.asiankoel_html,
            R.raw.snowleopard_html,
            R.raw.tawnyfrogmouth_html,
            R.raw.cloudedleopard_html,
            R.raw.magnificentfrigatebird_html,
            R.raw.tokaygecko_html,
            R.raw.malaysianhornedfrog_html,
            R.raw.alligatorsnappingturtle_html,
            R.raw.cuckoobee_html,
            R.raw.barnowl_html,
            R.raw.blackandgoldhowlermonkey_html,
            R.raw.asianelephant_html,
            R.raw.hyacinthmacaw_html,
            R.raw.bladdercicada_html,
            R.raw.siamang_html,
            R.raw.powersawcricket_html,
            R.raw.coquifrog_html,
            R.raw.weddellseal_html,
            R.raw.waterboatman_html,
            R.raw.oilbird_html,
            R.raw.northatlanticrightwhale_html,
            R.raw.tigerpistolshrimp_html,
            R.raw.whoopingcrane_html,
            R.raw.mandrill_html,
            R.raw.northamericanelk_html,
            R.raw.blacktailedtrainbearer_html,
            R.raw.westernlowlandgorilla_html,
            R.raw.bluepeafowl_html,
            R.raw.redcappedmanakin_html,
            R.raw.bluebirdofparadise_html,
            R.raw.capercaillie_html,
            R.raw.ringtailedlemur_html,
            R.raw.commonteal_html,
            R.raw.costaricantreefrog_html
            };

    private static int[] _soundIds = new int[] { 
            -1, // 1
            -1, // 2
            -1, // 3
            R.raw.africanlion, // 4
            -1, // 5
            -1, // 6
            -1, // 7
            -1, // 8
            -1, // 9
            -1, // 10
            -1, // 11
            -1, // 12
            -1, // 13
            -1, // 14
            -1, // 15
            -1, // 16
            -1, // 17
            -1, // 18
            -1, // 19
            -1, // 20
            -1, // 21
            -1, // 22
            -1, // 23
            R.raw.blackwoodpecker, // 24
            R.raw.prairierattlesnake, // 25
            -1, // 26
            -1, // 27
            -1, // 28
            -1, // 29
            -1, // 30
            -1, // 31
            -1, // 32
            -1, // 33
            -1, // 34
            R.raw.anophelesmosquito, // 35
            -1, // 36
            -1, // 37
            -1, // 38
            -1, // 39
            -1, // 40
            -1, // 41
            -1, // 42
            R.raw.americanalligator, // 43
            -1, // 44
            -1, // 45
            -1, // 46
            R.raw.chimpanzee, // 47
            -1, // 48
            -1, // 49
            -1, // 50
            R.raw.killerwhale, // 51
            R.raw.bengaltiger, // 52
            -1, // 53
            -1, // 54
            -1, // 55
            R.raw.europeanwolf, // 56
            R.raw.polarbear, // 57
            -1, // 58
            -1, // 59
            -1, // 60
            -1, // 61
            -1, // 62
            -1, // 63
            -1, // 64
            -1, // 65
            -1, // 66
            -1, // 67
            -1, // 68
            -1, // 69
            -1, // 70
            -1, // 71
            -1, // 72
            R.raw.greenheron, // 73
            -1, // 74
            -1, // 75
            -1, // 76
            -1, // 77
            -1, // 78
            -1, // 79
            -1, // 80
            -1, // 81
            -1, // 82
            -1, // 83
            -1, // 84
            -1, // 85
            R.raw.asianelephant, // 86
            -1, // 87
            R.raw.bladdercicada, // 88
            -1, // 89
            -1, // 90
            -1, // 91
            -1, // 92
            -1, // 93
            -1, // 94
            -1, // 95
            -1, // 96
            -1, // 97
            -1, // 98
            R.raw.northamericanelk, // 99
            -1, // 100
            R.raw.westernlowlandgorilla, // 101
            R.raw.bluepeafowl, // 102
            -1, // 103
            -1, // 104
            -1, // 105
            -1, // 106
            -1, // 107
            -1, // 108
            };

    private static Hashtable _descriptions = null;

    public static String getDescription(String s)
    {
        if (_descriptions == null)
        {
            _descriptions = new Hashtable();
            _descriptions.put("1010101010100101100", "1,Black Mamba");
            _descriptions.put("1010101010011001100", "2,Cheetah");
            _descriptions.put("1010101010010110010", "3,Brown Hare");
            _descriptions.put("1010101001101001100", "4,African Lion");
            _descriptions.put("1010101001100110010", "5,Peregrine Falcon");
            _descriptions.put("1010101001011010010", "6,Mantis Shrimp");
            _descriptions.put("1010101001010101100", "7,Springbok");
            _descriptions.put("1010100110101001100", "8,White-Throated Needletail");
            _descriptions.put("1010100110100110010", "9,Dragonfly");
            _descriptions.put("1010100110011010010", "10,Blue Wildebeest");
            _descriptions.put("1010100110010101100", "11,Free-Tailed Bat");
            _descriptions.put("1010100101101010010", "12,Warthog");
            _descriptions.put("1010100101100101100", "13,African Buffalo");
            _descriptions.put("1010100101011001100", "14,Honey Badger");
            _descriptions.put("1010100101010110010", "15,Greater One-Horned Rhinoceros");
            _descriptions.put("1010011010101001100", "16,Emperor Penguin");
            _descriptions.put("1010011010100110010", "17,Banded Mongoose");
            _descriptions.put("1010011010011010010", "18,Bar-Tailed Godwit");
            _descriptions.put("1010011010010101100", "19,Koala");
            _descriptions.put("1010011001101010010", "20,Bactrian Camel");
            _descriptions.put("1010011001100101100", "21,Boreal Chorus Frog");
            _descriptions.put("1010011001011001100", "22,Monarch Butterfly");
            _descriptions.put("1010011001010110010", "23,Pronghorn");
            _descriptions.put("1010010110101010010", "24,Black Woodpecker");
            _descriptions.put("1010010110100101100", "25,Prairie Rattlesnake");
            _descriptions.put("1010010110011001100", "26,Leopard Seal");
            _descriptions.put("1010010110010110010", "27,Southern Corroboree Frog");
            _descriptions.put("1010010101101001100", "28,Bornean Slow Loris");
            _descriptions.put("1010010101100110010", "29,Oyster Toadfish");
            _descriptions.put("1010010101011010010", "30,Saw-Scaled Viper");
            _descriptions.put("1010010101010101100", "31,Strawberry Poison-Frog");
            _descriptions.put("1001101010101001100", "32,Saltwater Crocodile");
            _descriptions.put("1001101010100110010", "33,Southern Cassowary");
            _descriptions.put("1001101010011010010", "34,Common Hippopotamus");
            _descriptions.put("1001101010010101100", "35,Anopheles Mosquito");
            _descriptions.put("1001101001101010010", "36,African Wild Dog");
            _descriptions.put("1001101001100101100", "37,Bornean Orangutan");
            _descriptions.put("1001101001011001100", "38,Woodpecker Finch");
            _descriptions.put("1001101001010110010", "39,Green Tree-Frog");
            _descriptions.put("1001100110101010010", "40,Brown Rat");
            _descriptions.put("1001100110100101100", "41,New Caledonian Crow");
            _descriptions.put("1001100110011001100", "42,Sea Otter");
            _descriptions.put("1001100110010110010", "43,American Alligator");
            _descriptions.put("1001100101101001100", "44,Egyptian Vulture");
            _descriptions.put("1001100101100110010", "45,Chipmunk");
            _descriptions.put("1001100101011010010", "46,Acorn Woodpecker");
            _descriptions.put("1001100101010101100", "47,Chimpanzee");
            _descriptions.put("1001011010101010010", "48,American Beaver");
            _descriptions.put("1001011010100101100", "49,Grizzly Bear");
            _descriptions.put("1001011010011001100", "50,Tasmanian Devil");
            _descriptions.put("1001011010010110010", "51,Killer Whale");
            _descriptions.put("1001011001101001100", "52,Bengal Tiger");
            _descriptions.put("1001011001100110010", "53,Komodo Dragon");
            _descriptions.put("1001011001011010010", "54,Fossa");
            _descriptions.put("1001011001010101100", "55,Monkey-Eating Eagle");
            _descriptions.put("1001010110101001100", "56,European Wolf");
            _descriptions.put("1001010110100110010", "57,Polar Bear");
            _descriptions.put("1001010110011010010", "58,Spotted Hyena");
            _descriptions.put("1001010110010101100", "59,Africanized Honey Bee");
            _descriptions.put("1001010101101010010", "60,Wolverine");
            _descriptions.put("1001010101100101100", "61,Babirusa");
            _descriptions.put("1001010101011001100", "62,Shoebill Stork");
            _descriptions.put("1001010101010110010", "63,Streaked Tenrec");
            _descriptions.put("0110101010101001100", "64,Eastern Tube-Nosed Bat");
            _descriptions.put("0110101010100110010", "65,Pygmy Three-Toed Sloth");
            _descriptions.put("0110101010011010010", "66,Proboscis Monkey");
            _descriptions.put("0110101010010101100", "67,Nine-Banded Armadillo");
            _descriptions.put("0110101001101010010", "68,Narwhal");
            _descriptions.put("0110101001100101100", "69,Marabou Stork");
            _descriptions.put("0110101001011001100", "70,Turtle Frog");
            _descriptions.put("0110101001010110010", "71,Southern Elephant-Seal ");
            _descriptions.put("0110100110101010010", "72,Saiga Antelope");
            _descriptions.put("0110100110100101100", "73,Green Heron");
            _descriptions.put("0110100110011001100", "74,Gaboon Viper");
            _descriptions.put("0110100110010110010", "75,Asian Koel");
            _descriptions.put("0110100101101001100", "76,Snow Leopard");
            _descriptions.put("0110100101100110010", "77,Tawny Frogmouth");
            _descriptions.put("0110100101011010010", "78,Clouded Leopard");
            _descriptions.put("0110100101010101100", "79,Magnificent Frigatebird ");
            _descriptions.put("0110011010101010010", "80,Tokay Gecko");
            _descriptions.put("0110011010100101100", "81,Malaysian Horned Frog");
            _descriptions.put("0110011010011001100", "82,Alligator Snapping Turtle");
            _descriptions.put("0110011010010110010", "83,Cuckoo Bee");
            _descriptions.put("0110011001101001100", "84,Barn Owl");
            _descriptions.put("0110011001100110010", "85,Black-and-Gold Howler Monkey");
            _descriptions.put("0110011001011010010", "86,Asian Elephant");
            _descriptions.put("0110011001010101100", "87,Hyacinth Macaw");
            _descriptions.put("0110010110101001100", "88,Bladder Cicada");
            _descriptions.put("0110010110100110010", "89,Siamang");
            _descriptions.put("0110010110011010010", "90,Power-Saw Cricket");
            _descriptions.put("0110010110010101100", "91,Coqui Frog");
            _descriptions.put("0110010101101010010", "92,Weddell Seal");
            _descriptions.put("0110010101100101100", "93,Water Boatman");
            _descriptions.put("0110010101011001100", "94,Oilbird");
            _descriptions.put("0110010101010110010", "95,North Atlantic Right Whale");
            _descriptions.put("0101101010101010010", "96,Tiger Pistol-shrimp");
            _descriptions.put("0101101010100101100", "97,Whooping Crane");
            _descriptions.put("0101101010011001100", "98,Mandrill");
            _descriptions.put("0101101010010110010", "99,North American Elk ");
            _descriptions.put("0101101001101001100", "100,Black-Tailed Trainbearer");
            _descriptions.put("0101101001100110010", "101,Western Lowland Gorilla");
            _descriptions.put("0101101001011010010", "102,Blue Peafowl");
            _descriptions.put("0101101001010101100", "103,Red-Capped Manakin");
            _descriptions.put("0101100110101001100", "104,Blue Bird-of-Paradise");
            _descriptions.put("0101100110100110010", "105,Capercaillie");
            _descriptions.put("0101100110011010010", "106,Ring-Tailed Lemur");
            _descriptions.put("0101100110010101100", "107,Common Teal");
            _descriptions.put("0101100101101010010", "108,Costa Rican Tree-frog");
            _descriptions.put("0101010101010101100", "127");
        }
        Object o = _descriptions.get(s);
        if (o != null)
            return (String) o;
        return s;
    }

    public static int getPictureID(int n)
    {
        if (n >= 1 && n <= 108)
            return _picureIds[n - 1];
        if (n == 127)
            return R.drawable.secret;
        return R.drawable.start;
    }

    public static int getSoundID(int n)
    {
        if (n >= 1 && n <= 108)
            return _soundIds[n - 1];
        return -1;
    }
    
    public static int getTextID(int n)
    {
        if (n >= 1 && n <= 108)
            return _textIds[n - 1];
        return R.raw.help_html;
    }

}

