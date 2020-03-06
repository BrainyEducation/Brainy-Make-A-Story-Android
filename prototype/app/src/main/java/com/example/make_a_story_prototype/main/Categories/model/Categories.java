package com.example.make_a_story_prototype.main.Categories.model;

import com.example.make_a_story_prototype.R;

public class Categories {
    private String[] categories = {
            "Animals",
            "Birds",
            "Body Parts",
            "Clothes",
            "Colors",
            "Describe",
            "Food",
            "House Stuff",
            "Outdoors",
            "People",
            "Places",
            "Things",
            "Tools",
            "Toys",
            "Vehicles",
            "Verbs",
            "Water Animals"
    };

    private Integer[] categoryImages = {
            R.drawable.animals_dogs,
            R.drawable.birds_bird,
            R.drawable.bodyparts_face,
            R.drawable.clothes_clothes,
            R.drawable.colors_blue,
            R.drawable.describe_afraid,
            R.drawable.food_sandwich,
            R.drawable.housestuff_sofa,
            R.drawable.outdoors_rainbow,
            R.drawable.people_mother,
            R.drawable.places_playground,
            R.drawable.things_flyingcarpet,
            R.drawable.tools_tools,
            R.drawable.toys_toys,
            R.drawable.vehicles_car,
            R.drawable.verbs_draw,
            R.drawable.wateranimals_fish
    };

    private Integer[] categoryAudio = {
            R.raw.animals,
            R.raw.birds,
            R.raw.bodyparts,
            R.raw.clothes,
            R.raw.colors,
            R.raw.describe,
            R.raw.food,
            R.raw.house_stuff,
            R.raw.outdoors,
            R.raw.people,
            R.raw.places,
            R.raw.things,
            R.raw.tools,
            R.raw.toys,
            R.raw.vehicles,
            R.raw.water_animals,
    };

    public String[] getCategories() {
        return categories;
    }

    public Integer[] getCategoryImages() {
        return categoryImages;
    }

    public Integer[] getCategoryAudio() {
        return categoryAudio;
    }
}
