package com.example.make_a_story_prototype.main.data.Word;

import com.example.make_a_story_prototype.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DebugWordRepository implements WordRepository {

    private static DebugWordRepository instance;

    public static DebugWordRepository getInstance() {
        return instance;
    }

    private Category animalCategory = new Category(0,"Animals", R.drawable.animals_dogs, R.raw.animals;
    private Category birdCategory = new Category(1,"Birds", R.drawable.birds_bird, R.raw.birds);
    private Category bodyCategory = new Category(2,"Body Parts", R.drawable.bodyparts_face, R.raw.bodyparts);
    private Category clothesCategory = new Category(4,"Clothes", R.drawable.clothes_clothes, R.raw.clothes);
    private Category colorCategory = new Category(5,"Colors", R.drawable.colors_blue, R.raw.colors);
    private Category describeCategory = new Category(6,"Describe", R.drawable.describe_afraid, R.raw.describe);
    private Category foodCategory = new Category(3,"Food", R.drawable.food_sandwich, R.raw.food);
    private Category houseCategory = new Category(7,"House Stuff", R.drawable.housestuff_sofa, R.raw.house_stuff);
    private Category outdoorCategory = new Category(8,"Outdoors", R.drawable.outdoors_rainbow, R.raw.outdoors);
    private Category peopleCategory = new Category(9,"People", R.drawable.people_mother, R.raw.people);
    private Category placeCategory = new Category(10,"Places", R.drawable.places_playground, R.raw.places);
    private Category thingCategory = new Category(11,"Things", R.drawable.things_flyingcarpet, R.raw.things);
    private Category toolCategory = new Category(12,"Tools", R.drawable.tools_tools, R.raw.tools);
    private Category toyCategory = new Category(13,"Toys", R.drawable.toys_toys, R.raw.toys);
    private Category vehicleCategory = new Category(14,"Vehicles", R.drawable.vehicles_car, R.raw.vehicles);
    private Category verbCategory = new Category(15,"Verbs", R.drawable.verbs_draw, R.raw.vehicles);
    private Category waterAnimalCategory = new Category(16,"Water Animals", R.drawable.wateranimals_fish, R.raw.water_animals);

    private Category[] categories = {
            animalCategory,
            birdCategory,
            bodyCategory,
            clothesCategory,
            colorCategory,
            describeCategory,
            foodCategory,
            houseCategory,
            outdoorCategory,
            peopleCategory,
            placeCategory,
            thingCategory,
            toolCategory,
            toyCategory,
            vehicleCategory,
            verbCategory,
            waterAnimalCategory
    };

    private Word[] words = {
            new Word(0, "ape", animalCategory, R.drawable.animals_ape, R.raw.animals_ape),
            new Word(1, "bat", animalCategory, R.drawable.animals_bat, R.raw.animals_bat),
            new Word(2, "bear", animalCategory, R.drawable.animals_bear, R.raw.animals_bear),
            new Word(3, "bug", animalCategory, R.drawable.animals_bug, R.raw.animals_bug),
            new Word(4, "camel", animalCategory, R.drawable.animals_camel, R.raw.animals_camel),
            new Word(5, "cat", animalCategory, R.drawable.animals_cat, R.raw.animals_cat),
            new Word(6, "collie", animalCategory, R.drawable.animals_collie, R.raw.animals_collie),
            new Word(7, "cow", animalCategory, R.drawable.animals_cow, R.raw.animals_cow),
            new Word(8, "dog", animalCategory, R.drawable.animals_dog, R.raw.animals_dog),
            new Word(9, "dogs", animalCategory, R.drawable.animals_dogs, R.raw.animals_dogs),
            new Word(10, "fox", animalCategory, R.drawable.animals_fox, R.raw.animals_fox),
            new Word(11, "goat", animalCategory, R.drawable.animals_goat, R.raw.animals_goat),
            new Word(12, "kitten", animalCategory, R.drawable.animals_kitten, R.raw.animals_kitten),
            new Word(13, "mole", animalCategory, R.drawable.animals_mole, R.raw.animals_mole),
            new Word(14, "monkey", animalCategory, R.drawable.animals_monkey, R.raw.animals_monkey),
            new Word(15, "moth", animalCategory, R.drawable.animals_moth, R.raw.animals_moth),
            new Word(16, "mouse", animalCategory, R.drawable.animals_mouse, R.raw.animals_mouse),
            new Word(17, "rabbit", animalCategory, R.drawable.animals_rabbit, R.raw.animals_rabbit),
            new Word(18, "sheep", animalCategory, R.drawable.animals_sheep, R.raw.animals_sheep),
            new Word(19, "skunk", animalCategory, R.drawable.animals_skunk, R.raw.animals_skunk),
            new Word(20, "snail", animalCategory, R.drawable.animals_snail, R.raw.animals_snail),
            new Word(21, "tail", animalCategory, R.drawable.animals_tail, R.raw.animals_tail),
            new Word(22, "wasp", animalCategory, R.drawable.animals_wasp, R.raw.animals_wasp),
            new Word(23, "wolf", animalCategory, R.drawable.animals_wolf, R.raw.animals_wolf),
            new Word(24, "zebra", animalCategory, R.drawable.animals_zebra, R.raw.animals_zebra),

            new Word(25, "canary", birdCategory, R.drawable.birds_canary, R.raw.birds_canary),
            new Word(26, "ostrich", birdCategory, R.drawable.birds_ostrich, R.raw.birds_ostrich),
            new Word(27, "owl", birdCategory, R.drawable.birds_owl, R.raw.birds_owl),
            new Word(28, "parrot", birdCategory, R.drawable.birds_parrot, R.raw.birds_parrot),
            new Word(29, "swan", birdCategory, R.drawable.birds_swan, R.raw.birds_swan),

            new Word(30, "face", bodyCategory, R.drawable.bodyparts_face, R.raw.bodyparts_face),
            new Word(31, "foot", bodyCategory, R.drawable.bodyparts_foot, R.raw.bodyparts_foot),
            new Word(32, "hand", bodyCategory, R.drawable.bodyparts_hand, R.raw.bodyparts_hand),
            new Word(33, "mouth", bodyCategory, R.drawable.bodyparts_mouth, R.raw.bodyparts_mouth),
            new Word(34, "nose", bodyCategory, R.drawable.bodyparts_nose, R.raw.bodyparts_nose),
            new Word(35, "thumb", bodyCategory, R.drawable.bodyparts_thumb, R.raw.bodyparts_thumb),
            new Word(36, "toe", bodyCategory, R.drawable.bodyparts_toe, R.raw.bodyparts_toe),

            new Word(37, "boots", clothesCategory, R.drawable.clothes_boots, R.raw.clothes_boots),
            new Word(38, "clothes", clothesCategory, R.drawable.clothes_clothes, R.raw.clothes_clothes),
            new Word(39, "glove", clothesCategory, R.drawable.clothes_glove, R.raw.clothes_glove),
            new Word(40, "purse", clothesCategory, R.drawable.clothes_purse, R.raw.clothes_purse),
            new Word(41, "scarf", clothesCategory, R.drawable.clothes_scarf, R.raw.clothes_scarf),
            new Word(42, "shirt", clothesCategory, R.drawable.clothes_shirt, R.raw.clothes_shirt),
            new Word(43, "skirt", clothesCategory, R.drawable.clothes_skirt, R.raw.clothes_skirt),
            new Word(44, "suit", clothesCategory, R.drawable.clothes_suit, R.raw.clothes_suit),
            new Word(45, "tie", clothesCategory, R.drawable.clothes_tie, R.raw.clothes_tie),
            new Word(46, "wig", clothesCategory, R.drawable.clothes_wig, R.raw.clothes_wig),

            new Word(47, "blue", colorCategory, R.drawable.colors_blue, R.raw.colors_blue),
            new Word(48, "brown", colorCategory, R.drawable.colors_brown, R.raw.colors_brown),
            new Word(49, "gold", colorCategory, R.drawable.colors_gold, R.raw.colors_gold),
            new Word(50, "purple", colorCategory, R.drawable.colors_purple, R.raw.colors_purple),
            new Word(51, "silver", colorCategory, R.drawable.colors_silver, R.raw.colors_silver),
            new Word(52, "yellow", colorCategory, R.drawable.colors_yellow, R.raw.colors_yellow),

            new Word(53, "afraid", describeCategory, R.drawable.describe_afraid, R.raw.describing_afraid),
            new Word(54, "cloudy", describeCategory, R.drawable.describe_cloudy, R.raw.describing_cloudy),
            new Word(55, "dark", describeCategory, R.drawable.describe_dark, R.raw.describing_dark),
            new Word(56, "five", describeCategory, R.drawable.describe_five, R.raw.describing_five),
            new Word(57, "hilly", describeCategory, R.drawable.describe_hilly, R.raw.describing_hilly),
            new Word(58, "hot", describeCategory, R.drawable.describe_hot, R.raw.describing_hot),
            new Word(59, "old", describeCategory, R.drawable.describe_old, R.raw.describing_old),
            new Word(60, "quiet", describeCategory, R.drawable.describe_quiet, R.raw.describing_quiet),
            new Word(61, "silly", describeCategory, R.drawable.describe_silly, R.raw.describing_silly),
            new Word(62, "six", describeCategory, R.drawable.describe_six, R.raw.describing_six),
            new Word(63, "sixteen", describeCategory, R.drawable.describe_sixteen, R.raw.describing_sixteen),
            new Word(64, "sleepy", describeCategory, R.drawable.describe_sleepy, R.raw.describing_sleepy),

            new Word(65, "cake", foodCategory, R.drawable.food_cake, R.raw.food_cake),
            new Word(66, "candy", foodCategory, R.drawable.food_candy, R.raw.food_candy),
            new Word(67, "cookies", foodCategory, R.drawable.food_cookies, R.raw.food_cookies),
            new Word(68, "corn", foodCategory, R.drawable.food_corn, R.raw.food_corn),
            new Word(69, "grapes", foodCategory, R.drawable.food_grapes, R.raw.food_grapes),
            new Word(70, "hamburger", foodCategory, R.drawable.food_hamburger, R.raw.food_hamburger),
            new Word(71, "nuts", foodCategory, R.drawable.food_nuts, R.raw.food_nuts),
            new Word(72, "pie", foodCategory, R.drawable.food_pie, R.raw.food_pie),
            new Word(73, "plum", foodCategory, R.drawable.food_plum, R.raw.food_plum),
            new Word(74, "pretzel", foodCategory, R.drawable.food_pretzel, R.raw.food_pretzel),
            new Word(75, "sandwich", foodCategory, R.drawable.food_sandwich, R.raw.food_sandwich),

            new Word(76, "bed", houseCategory, R.drawable.housestuff_bed, R.raw.housestuff_bed),
            new Word(77, "blanket", houseCategory, R.drawable.housestuff_blanket, R.raw.housestuff_blanket),
            new Word(78, "broom", houseCategory, R.drawable.housestuff_broom, R.raw.housestuff_broom),
            new Word(79, "cushion", houseCategory, R.drawable.housestuff_cushion, R.raw.housestuff_cushion),
            new Word(80, "fork", houseCategory, R.drawable.housestuff_fork, R.raw.housestuff_fork),
            new Word(81, "fridge", houseCategory, R.drawable.housestuff_fridge, R.raw.housestuff_fridge),
            new Word(82, "key", houseCategory, R.drawable.housestuff_key, R.raw.housestuff_key),
            new Word(83, "light", houseCategory, R.drawable.housestuff_light, R.raw.housestuff_light),
            new Word(84, "oven", houseCategory, R.drawable.housestuff_oven, R.raw.housestuff_oven),
            new Word(85, "plug", houseCategory, R.drawable.housestuff_plug, R.raw.housestuff_plug),
            new Word(86, "pot", houseCategory, R.drawable.housestuff_pot, R.raw.housestuff_pot),
            new Word(87, "saucepan", houseCategory, R.drawable.housestuff_saucepan, R.raw.housestuff_saucepan),
            new Word(88, "soap", houseCategory, R.drawable.housestuff_soap, R.raw.housestuff_soap),
            new Word(89, "sofa", houseCategory, R.drawable.housestuff_sofa, R.raw.housestuff_sofa),
            new Word(90, "spoons", houseCategory, R.drawable.housestuff_spoons, R.raw.housestuff_spoons),
            new Word(91, "teapot", houseCategory, R.drawable.housestuff_teapot, R.raw.housestuff_teapot),
            new Word(92, "toilet", houseCategory, R.drawable.housestuff_toilet, R.raw.housestuff_toilet),

            new Word(93, "grass", outdoorCategory, R.drawable.outdoors_grass, R.raw.outdoors_grass),
            new Word(94, "ice", outdoorCategory, R.drawable.outdoors_ice, R.raw.outdoors_ice),
            new Word(95, "moon", outdoorCategory, R.drawable.outdoors_moon, R.raw.outdoors_moon),
            new Word(96, "rainbow", outdoorCategory, R.drawable.outdoors_rainbow, R.raw.outdoors_rainbow),
            new Word(97, "sky", outdoorCategory, R.drawable.outdoors_sky, R.raw.outdoors_sky),
            new Word(98, "snow", outdoorCategory, R.drawable.outdoors_snow, R.raw.outdoors_snow),
            new Word(99, "star", outdoorCategory, R.drawable.outdoors_star, R.raw.outdoors_star),
            new Word(100, "statue", outdoorCategory, R.drawable.outdoors_statue, R.raw.outdoors_statue),
            new Word(101, "straw", outdoorCategory, R.drawable.outdoors_straw, R.raw.outdoors_straw),
            new Word(102, "tree", outdoorCategory, R.drawable.outdoors_tree, R.raw.outdoors_tree),
            new Word(103, "wall", outdoorCategory, R.drawable.outdoors_wall, R.raw.outdoors_wall),

            new Word(104, "baby", peopleCategory, R.drawable.people_baby, R.raw.people_baby),
            new Word(105, "boy", peopleCategory, R.drawable.people_boy, R.raw.people_boy),
            new Word(106, "bride", peopleCategory, R.drawable.people_bride, R.raw.people_bride),
            new Word(107, "brother", peopleCategory, R.drawable.people_brother, R.raw.people_brother),
            new Word(108, "child", peopleCategory, R.drawable.people_child, R.raw.people_child),
            new Word(109, "clown", peopleCategory, R.drawable.people_clown, R.raw.people_clown),
            new Word(110, "daughter", peopleCategory, R.drawable.people_daughter, R.raw.people_daughter),
            new Word(111, "family", peopleCategory, R.drawable.people_family, R.raw.people_family),
            new Word(112, "father", peopleCategory, R.drawable.people_father, R.raw.people_father),
            new Word(113, "girl", peopleCategory, R.drawable.people_girl, R.raw.people_girl),
            new Word(114, "grandfather", peopleCategory, R.drawable.people_grandfather, R.raw.people_grandfather),
            new Word(115, "grandmother", peopleCategory, R.drawable.people_grandmother, R.raw.people_grandmother),
            new Word(116, "juggler", peopleCategory, R.drawable.people_juggler, R.raw.people_juggler),
            new Word(117, "king", peopleCategory, R.drawable.people_king, R.raw.people_king),
            new Word(118, "laundress", peopleCategory, R.drawable.people_laundress, R.raw.people_laundress),
            new Word(119, "man", peopleCategory, R.drawable.people_man, R.raw.people_man),
            new Word(120, "mother", peopleCategory, R.drawable.people_mother, R.raw.people_mother),
            new Word(121, "queen", peopleCategory, R.drawable.people_queen, R.raw.people_queen),

            new Word(122, "bridge", placeCategory, R.drawable.places_bridge, R.raw.places_bridge),
            new Word(123, "playground", placeCategory, R.drawable.places_playground, R.raw.places_playground),
            new Word(124, "volcano", placeCategory, R.drawable.places_volcano, R.raw.places_volcano),
            new Word(125, "zoo", placeCategory, R.drawable.places_zoo, R.raw.places_zoo),

            new Word(126, "bag", thingCategory, R.drawable.things_bag, R.raw.things_bag),
            new Word(127, "bubble", thingCategory, R.drawable.things_bubble, R.raw.things_bubble),
            new Word(128, "cast", thingCategory, R.drawable.things_cast, R.raw.things_cast),
            new Word(129, "cauldron", thingCategory, R.drawable.things_cauldron, R.raw.things_cauldron),
            new Word(130, "clarinet", thingCategory, R.drawable.things_clarinet, R.raw.things_clarinet),
            new Word(131, "coin", thingCategory, R.drawable.things_coin, R.raw.things_coin),
            new Word(132, "flute", thingCategory, R.drawable.things_flute, R.raw.things_flute),
            new Word(133, "flying carpet", thingCategory, R.drawable.things_flute, R.raw.things_flute),
            new Word(134, "fringe", thingCategory, R.drawable.things_flute, R.raw.things_flute),
            new Word(135, "glass", thingCategory, R.drawable.things_flute, R.raw.things_flute),
            new Word(136, "music", thingCategory, R.drawable.things_flute, R.raw.things_flute),
            new Word(137, "net", thingCategory, R.drawable.things_flute, R.raw.things_flute),
            new Word(138, "pearl", thingCategory, R.drawable.things_flute, R.raw.things_flute),
            new Word(139, "pencil", thingCategory, R.drawable.things_flute, R.raw.things_flute),
            new Word(140, "question", thingCategory, R.drawable.things_flute, R.raw.things_flute),
            new Word(141, "skis", thingCategory, R.drawable.things_flute, R.raw.things_flute),
            new Word(142, "square", thingCategory, R.drawable.things_flute, R.raw.things_flute),
            new Word(143, "tuba", thingCategory, R.drawable.things_flute, R.raw.things_flute),
            new Word(144, "wheel", thingCategory, R.drawable.things_flute, R.raw.things_flute),
            new Word(145, "zipper", thingCategory, R.drawable.things_flute, R.raw.things_flute),

            new Word(146, "axe", toolCategory, R.drawable.tools_axe, R.raw.tools_axe),
            new Word(147, "drill", toolCategory, R.drawable.tools_drill, R.raw.tools_drill),
            new Word(148, "hatchet", toolCategory, R.drawable.tools_hatchet, R.raw.tools_hatchet),
            new Word(149, "nail", toolCategory, R.drawable.tools_nail, R.raw.tools_nail),
            new Word(150, "rake", toolCategory, R.drawable.tools_rake, R.raw.tools_rake),
            new Word(151, "saw", toolCategory, R.drawable.tools_saw, R.raw.tools_saw),
            new Word(152, "tools", toolCategory, R.drawable.tools_tools, R.raw.tools_tools),

            new Word(153, "ball", toyCategory, R.drawable.toys_ball, R.raw.toys_ball),
            new Word(154, "block", toyCategory, R.drawable.toys_block, R.raw.toys_block),
            new Word(155, "boat", toyCategory, R.drawable.toys_boat, R.raw.toys_boat),
            new Word(156, "car", toyCategory, R.drawable.toys_car, R.raw.toys_car),
            new Word(157, "crayon", toyCategory, R.drawable.toys_crayon, R.raw.toys_crayon),
            new Word(158, "jeep", toyCategory, R.drawable.toys_jeep, R.raw.toys_jeep),
            new Word(159, "plane", toyCategory, R.drawable.toys_plane, R.raw.toys_plane),
            new Word(160, "present", toyCategory, R.drawable.toys_present, R.raw.toys_present),
            new Word(161, "slide", toyCategory, R.drawable.toys_slide, R.raw.toys_slide),
            new Word(162, "stilts", toyCategory, R.drawable.toys_stilts, R.raw.toys_stilts),
            new Word(163, "swing", toyCategory, R.drawable.toys_swing, R.raw.toys_swing),
            new Word(164, "toys", toyCategory, R.drawable.toys_toys, R.raw.toys_toys),
            new Word(165, "truck", toyCategory, R.drawable.toys_truck, R.raw.toys_truck),
            new Word(166, "unicycle", toyCategory, R.drawable.toys_unicycle, R.raw.toys_unicycle),
            new Word(167, "wagon", toyCategory, R.drawable.toys_wagon, R.raw.toys_wagon),
            new Word(168, "yoyo", toyCategory, R.drawable.toys_yoyo, R.raw.toys_yoyo),

            new Word(169, "airplane", vehicleCategory, R.drawable.vehicles_airplane, R.raw.vehicles_airplane),
            new Word(170, "ambulance", vehicleCategory, R.drawable.vehicles_ambulance, R.raw.vehicles_ambulance),
            new Word(171, "boat", vehicleCategory, R.drawable.vehicles_boat, R.raw.vehicles_boat),
            new Word(172, "bug", vehicleCategory, R.drawable.vehicles_bug, R.raw.vehicles_bug),
            new Word(173, "bus", vehicleCategory, R.drawable.vehicles_bus, R.raw.vehicles_bus),
            new Word(174, "car", vehicleCategory, R.drawable.vehicles_car, R.raw.vehicles_car),
            new Word(175, "crane", vehicleCategory, R.drawable.vehicles_crane, R.raw.vehicles_crane),
            new Word(176, "dozer", vehicleCategory, R.drawable.vehicles_dozer, R.raw.vehicles_dozer),
            new Word(177, "jeep", vehicleCategory, R.drawable.vehicles_jeep, R.raw.vehicles_jeep),
            new Word(178, "taxi", vehicleCategory, R.drawable.vehicles_taxi, R.raw.vehicles_taxi),
            new Word(179, "truck", vehicleCategory, R.drawable.vehicles_truck, R.raw.vehicles_truck),
            new Word(180, "van", vehicleCategory, R.drawable.vehicles_van, R.raw.vehicles_van),

            new Word(181, "balance", verbCategory, R.drawable.verbs_balance, R.raw.verbs_balance),
            new Word(182, "blew", verbCategory, R.drawable.verbs_blew, R.raw.verbs_blew),
            new Word(183, "burn", verbCategory, R.drawable.verbs_burn, R.raw.verbs_burn),
            new Word(184, "clean", verbCategory, R.drawable.verbs_clean, R.raw.verbs_clean),
            new Word(185, "cry", verbCategory, R.drawable.verbs_cry, R.raw.verbs_cry),
            new Word(186, "cut", verbCategory, R.drawable.verbs_cut, R.raw.verbs_cut),
            new Word(187, "dig", verbCategory, R.drawable.verbs_dig, R.raw.verbs_dig),
            new Word(188, "draw", verbCategory, R.drawable.verbs_draw, R.raw.verbs_draw),
            new Word(189, "eat", verbCategory, R.drawable.verbs_eat, R.raw.verbs_eat),
            new Word(190, "fall", verbCategory, R.drawable.verbs_fall, R.raw.verbs_fall),
            new Word(191, "fish", verbCategory, R.drawable.verbs_fish, R.raw.verbs_fish),
            new Word(192, "flew", verbCategory, R.drawable.verbs_flew, R.raw.verbs_flew),
            new Word(193, "hit", verbCategory, R.drawable.verbs_hit, R.raw.verbs_hit),
            new Word(194, "hug", verbCategory, R.drawable.verbs_hug, R.raw.verbs_hug),
            new Word(195, "jump", verbCategory, R.drawable.verbs_jump, R.raw.verbs_jump),

            new Word(196, "beaver", waterAnimalCategory, R.drawable.wateranimals_beaver, R.raw.wateranimals_beaver),
            new Word(197, "clam", waterAnimalCategory, R.drawable.wateranimals_clam, R.raw.wateranimals_clam),
            new Word(198, "fish", waterAnimalCategory, R.drawable.wateranimals_fish, R.raw.wateranimals_fish),
            new Word(199, "frog", waterAnimalCategory, R.drawable.wateranimals_frog, R.raw.wateranimals_frog),
            new Word(200, "gator", waterAnimalCategory, R.drawable.wateranimals_gator, R.raw.wateranimals_gator),
            new Word(201, "oyster", waterAnimalCategory, R.drawable.wateranimals_oyster, R.raw.wateranimals_oyster),
            new Word(202, "walrus", waterAnimalCategory, R.drawable.wateranimals_walrus, R.raw.wateranimals_walrus),
            new Word(203, "whale", waterAnimalCategory, R.drawable.wateranimals_whale, R.raw.wateranimals_whale),

    };

    @Override
    public List<Category> getCategories() {
        return Arrays.asList(categories);
    }

    @Override
    public List<Word> getWordsForCategory(Category category) {
        List<Word> results = new ArrayList<>();
        for (Word word : words) {
            if (word.getCategory().getId() == category.getId()) {
                results.add(word);
            }
        }

        return results;
    }

    @Override
    public Word getWord(int id) {
        for (Word word : words) {
            if (word.getId() == id) {
                return word;
            }
        }

        return null;
    }

}
