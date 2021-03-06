package com.example.make_a_story_prototype.main.data.Story.test_data;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.data.Story.model.Story;
import com.example.make_a_story_prototype.main.data.Story.model.StoryBlank;
import com.example.make_a_story_prototype.main.data.Story.model.StoryBlankIdentifier;
import com.example.make_a_story_prototype.main.data.Story.model.StoryPage;
import com.example.make_a_story_prototype.main.data.Story.model.StorySegment;
import com.example.make_a_story_prototype.main.data.Story.model.StoryText;
import com.example.make_a_story_prototype.main.data.Story.model.ImageLocation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data_TheSpaceAlien {
    public static Story sampleStory() {
        List<StoryPage> pages = new ArrayList<>();
        pages.add(sampleStoryPage1());
        pages.add(sampleStoryPage2());
        pages.add(sampleStoryPage3());
        pages.add(sampleStoryPage4());
        pages.add(sampleStoryPage5());

        return new Story(1,"The Space Alien", pages, R.drawable.story_space_alien_background);
    }



    private static StoryPage sampleStoryPage1() {
        List<StorySegment> segments = new ArrayList<>();

        segments.add(new StoryText("\tOne Saturday evening ", R.raw.space_alien_segment_1));
        segments.add(new StoryBlankIdentifier("A-2"));
        segments.add(new StoryText(" and ", R.raw.space_alien_segment_2));
        segments.add(new StoryBlankIdentifier("C-2"));
        segments.add(new StoryText(" made a tent to camp out in the back "
                        + "yard. They griped and whined and complained to each other about a school "
                        + "assignment due next week: to stand in front of the whole class and show "
                        + "pictures and talk about a special place they had visited. Neither one had "
                        + "any special pictures of any place special, and they both knew the "
                        + "teacher would embarrass them, and the other kids would tease them, and Monday "
                        + "would be terrifishously, awfulishously, horrifishously bad. "
                        + "Feeling glum, ", R.raw.space_alien_segment_3));
        segments.add(new StoryBlankIdentifier("A-2"));
        segments.add(new StoryText(" snuggled tight in some blankets and ", R.raw.space_alien_segment_4));
        segments.add(new StoryBlankIdentifier("C-2"));
        segments.add(new StoryText(" curled up in a sleeping bag, when about "
                        + "midnight a strange-shaped shadow flickered on their tent wall.\n"
                        + "\n\t\"What’s that?” asked ", R.raw.space_alien_segment_5));
        segments.add(new StoryBlankIdentifier("A-2"));
        segments.add(new StoryText(".\n\t\"Maybe some ", R.raw.space_alien_segment_6));
        segments.add(new StoryBlankIdentifier("AA"));

        segments.add(new StoryText("\". Or a maybe some kind of \"", R.raw.space_alien_segment_7));
        segments.add(new StoryBlankIdentifier("BB"));
        segments.add(new StoryText(",\" guessed ", R.raw.space_alien_segment_8));
        segments.add(new StoryBlankIdentifier("C-2"));
        segments.add(new StoryText("\n\n\tThey stuck their noses outside to find a "
                        + "weird looking space alien just their size.", R.raw.space_alien_segment_9_1));

        Map<String, ImageLocation> imageLocations = new HashMap<>();
        imageLocations.put("AA", new ImageLocation("AA", 11f, 10f, 200, 200, 0));
        imageLocations.put("BB", new ImageLocation("BB", 73f, 10f, 200, 200, 0));
        imageLocations.put("A-2", new ImageLocation("A-2", 5f, 58f, 250, 250, 0));
        imageLocations.put("C-2", new ImageLocation("C-2", 69f, 58f, 250, 250, 0));

        return new StoryPage(R.drawable.story_space_alien_1, segments, imageLocations);
    }

    private static StoryPage sampleStoryPage2() {
        List<StorySegment> segments = new ArrayList<>();

        segments.add(new StoryText("\t\"Please help me!\" \n"
                        + "\t\"How?\"\n"
                        + "\t\"For my school project I need pictures of earth stuff, and I took a few pictures but I need more.\"\n"
                        + "\t\"Show us.\"\n"
                        + "\n\tSpace Alien punched a shiny elbow button and twisted a fancy shoulder dial, and Space Alien’s tummy screen displayed a glowy ", R.raw.space_alien_segment_9_2));
        segments.add(new StoryBlankIdentifier("CC"));
        segments.add(new StoryText(".\n\n\t\"That’s a strange looking earth planet ", R.raw.space_alien_segment_10));
        segments.add(new StoryBlankIdentifier("DD"));
        segments.add(new StoryText(".\"\n\t\"Nope. Actually, a pretty nice ", R.raw.space_alien_segment_11));
        segments.add(new StoryBlankIdentifier("CC"));
        segments.add(new StoryText(".\"\n\t\"No! Are you sure?\"\n"
                    + "\tBoth kids nodded yes.\n\t\"But my sister said — I just feel so ", R.raw.space_alien_segment_12));
        segments.add(new StoryBlankIdentifier("FF"));
        segments.add(new StoryText(". It makes me want to ", R.raw.space_alien_segment_13));
        segments.add(new StoryBlankIdentifier("GG"));

        Map<String, ImageLocation> imageLocations = new HashMap<>();
        imageLocations.put("CC", new ImageLocation("CC", 45f, 30f, 125, 125, 0));
        imageLocations.put("DD", new ImageLocation("DD", 42f, 70f, 200, 200, 0));
        imageLocations.put("A-2", new ImageLocation("A-2", 7f, 8f, 250, 250, 0));
        imageLocations.put("C-2", new ImageLocation("C-2", 71f, 8f, 250, 250, 0));
        imageLocations.put("FF", null);
        imageLocations.put("GG", null);



        return new StoryPage(R.drawable.story_space_alien_2, segments, imageLocations);
    }

    private static StoryPage sampleStoryPage3() {
        List<StorySegment> segments = new ArrayList<>();

        segments.add(new StoryText("\"Well, what about my ", R.raw.space_alien_segment_14));
        segments.add(new StoryBlankIdentifier("HH"));
        segments.add(new StoryText("?\" \n\t\"Sorry. But you’ve got a really nice ", R.raw.space_alien_segment_15));
        segments.add(new StoryBlankIdentifier("JJ"));
        segments.add(new StoryText(".\"\n\t\"I’ll fail my school project!\"\n"
                    + "\t\"No way!  We’ll help.\"\n"
                    + "\t\"What kinds of pictures do you need?\"\n"
                    + "\t\"Anything! Everything!\"\n\n"
                    + "\tWhile everyone else in the house slept tight, the kids showed Space " +
                "Alien lots of things — some toys, some real.\n\n", R.raw.space_alien_segment_16));

        Map<String, ImageLocation> imageLocations = new HashMap<>();
        imageLocations.put("HH", new ImageLocation("HH", 42f, 34f, 125, 125, 0));
        imageLocations.put("JJ", new ImageLocation("JJ", 42f, 70f, 200, 200, 0));
        imageLocations.put("A-2", new ImageLocation("A-2", 7f, 8f, 250, 250, 0));
        imageLocations.put("C-2", new ImageLocation("C-2", 71f, 8f, 250, 250, 0));

        return new StoryPage(R.drawable.story_space_alien_3, segments, imageLocations);
    }

    private static StoryPage sampleStoryPage4() {
        List<StorySegment> segments = new ArrayList<>();

        segments.add(new StoryBlankIdentifier("KK"));
        segments.add(new StoryText(", I’m sure! My big brother told me.”\n\t\""
                    + "Big brother must have been teasing. Guess this.\"\n\t\"", R.raw.space_alien_segment_17));
        segments.add(new StoryBlankIdentifier("MM"));
        segments.add(new StoryText(".  Absolutely positively!\"\n"
                    + "\t\"Nope,\" \"", R.raw.space_alien_segment_18));
        segments.add(new StoryBlankIdentifier("NN"));
        segments.add(new StoryText(".\" \n\n\tThen Space Alien started to ", R.raw.space_alien_segment_19));
        segments.add(new StoryBlankIdentifier("OO"));
        segments.add(new StoryText(" and ", R.raw.space_alien_segment_20));
        segments.add(new StoryBlankIdentifier("PP"));
        segments.add(new StoryText(".\n\n"
                    + "\t\"Why are you doing that?\"\n"
                    + "\t\"That’s how we show we’re confused on my planet.\"\n"
                    + "\t\"We mostly just scratch our heads.\"\n"
                    + "\t\"What do you do when you’re angry?\"\n"
                    + "\t\"", R.raw.space_alien_segment_21));
        segments.add(new StoryBlankIdentifier("QQ"));
        segments.add(new StoryText(".\" \n"
                    + "\t\"And when you’re happy?\"\n"
                    + "\t\"Mostly we ", R.raw.space_alien_segment_22));
        segments.add(new StoryBlankIdentifier("RR"));
        segments.add(new StoryBlankIdentifier("A-2"));
        segments.add(new StoryText(" and ", R.raw.space_alien_segment_23));
        segments.add(new StoryBlankIdentifier("C-2"));
        segments.add(new StoryText("just shook their heads.\n"
                        + "\t\"Want to ride along while I check out some more freaky strange stuff?\"\n"
                        + "\t\"Sure!\""
                        + "\n\n\tSpace Alien clicked heels, and a weird unearthly contraption " +
                "quick-scooted over and hovered in the air beside their ankles.", R.raw.space_alien_segment_24));

        Map<String, ImageLocation> imageLocations = new HashMap<>();
        imageLocations.put("KK", new ImageLocation("KK", 18f, 4f, 200, 200, 0));
        // missing in segments list?
        imageLocations.put("LL", new ImageLocation("LL", 68f, 4f, 200, 200, 0));

        imageLocations.put("MM", new ImageLocation("MM", 18f, 71f, 200, 200, 0));
        imageLocations.put("NN", new ImageLocation("NN", 64f, 71f, 200, 200, 0));
        imageLocations.put("OO", null);
        imageLocations.put("PP", null);
        imageLocations.put("QQ", null);
        imageLocations.put("RR", null);

        imageLocations.put("A-2", new ImageLocation("A-2", 3f, 33f, 250, 250, 0));
        imageLocations.put("C-2", new ImageLocation("C-2", 72f, 33f, 250, 250, 0));

        return new StoryPage(R.drawable.story_space_alien_4, segments, imageLocations);
    }

    private static StoryPage sampleStoryPage5() {
        List<StorySegment> segments = new ArrayList<>();

        segments.add(new StoryText("\"What a great skateboard!\"\n"
                    + "\t\"Fantabulously SUPER skateboard!\"\n"
                    + "\t\"Space-board!\"\n\n"
                    + "\tAll three hopped on and flew away soaring high over a big ", R.raw.space_alien_segment_24));
        segments.add(new StoryBlankIdentifier("SS"));
        segments.add(new StoryText(" and an even bigger ", R.raw.space_alien_segment_25));
        segments.add(new StoryBlankIdentifier("TT"));
        segments.add(new StoryText(", curly-cueing around some ", R.raw.space_alien_segment_26));
        segments.add(new StoryBlankIdentifier("UU"));
        segments.add(new StoryText(" and nearly knocking over an in-the-way ", R.raw.space_alien_segment_27));
        segments.add(new StoryBlankIdentifier("VV"));
        segments.add(new StoryText(". Space Alien snapped picture after picture, ", R.raw.space_alien_segment_28));
        segments.add(new StoryBlankIdentifier("WW"));

        segments.add(new StoryText(" and ", R.raw.space_alien_segment_29));
        segments.add(new StoryBlankIdentifier("XX"));
        segments.add(new StoryText(" and ", R.raw.space_alien_segment_30));
        segments.add(new StoryBlankIdentifier("YY"));
        segments.add(new StoryText(" and ", R.raw.space_alien_segment_31));
        segments.add(new StoryBlankIdentifier("ZZ"));
        segments.add(new StoryText(".\n\n"
                + "\t\"That’s enough. Thanks for helping me do the best school project ever!\"\n"
                + "\t\"Glad to help. But you know—\"\n"
                + "\t\"What?\"\n"
                + "\t\"We’ve got our own school project due next week.\"\n"
                + "\t\"About some place we’d like to visit.\"\n"
                + "\t\"Do you think, maybe—\"\n"
                + "\t\"Maybe—\"\n"
                + "\t\"I’ll be back same time tomorrow night! Bring your cameras!\"\n"
                + "\tAnd they did!", R.raw.space_alien_segment_32));

        Map<String, ImageLocation> imageLocations = new HashMap<>();
        imageLocations.put("SS", new ImageLocation("SS", 12f, 56f, 150, 150, 0));
        imageLocations.put("TT", new ImageLocation("TT", 32f, 56f, 150, 150, 0));
        imageLocations.put("UU", new ImageLocation("UU", 51f, 56f, 150, 150, 0));
        imageLocations.put("VV", new ImageLocation("VV", 71f, 56f, 150, 150, 0));

        imageLocations.put("WW", new ImageLocation("WW", 12f, 77f, 150, 150, 0));
        imageLocations.put("XX", new ImageLocation("XX", 33f, 77f, 150, 150, 0));
        imageLocations.put("YY", new ImageLocation("YY", 51f, 77f, 150, 150, 0));
        imageLocations.put("ZZ", new ImageLocation("ZZ", 71f, 77f, 150, 150, 0));

        imageLocations.put("A-2", new ImageLocation("A-2", 9f, 10f, 275, 275, 0));
        imageLocations.put("C-2", new ImageLocation("C-2", 56f, 10f, 275, 275, 0));

        return new StoryPage(R.drawable.story_space_alien_5, segments, imageLocations);
    }

    private static Map<String, StoryBlank> blanks() {
        Map<String, StoryBlank> blanks = new HashMap<>();

        blanks.put("A-2", new StoryBlank("A-2"));
        blanks.put("C-2", new StoryBlank("C-2"));
        blanks.put("AA",new StoryBlank("AA"));
        blanks.put("BB",new StoryBlank("BB"));
        blanks.put("CC",new StoryBlank("CC"));
        blanks.put("DD",new StoryBlank("DD"));
        blanks.put("FF",new StoryBlank("FF"));
        blanks.put("GG",new StoryBlank("GG"));
        blanks.put("HH",new StoryBlank("HH"));
        blanks.put("JJ",new StoryBlank("JJ"));
        blanks.put("KK",new StoryBlank("KK"));
        blanks.put("LL",new StoryBlank("LL"));
        blanks.put("MM",new StoryBlank("MM"));
        blanks.put("NN",new StoryBlank("NN"));
        blanks.put("OO",new StoryBlank("OO"));
        blanks.put("PP",new StoryBlank("PP"));
        blanks.put("QQ",new StoryBlank("QQ"));
        blanks.put("RR",new StoryBlank("RR"));
        blanks.put("SS",new StoryBlank("SS"));
        blanks.put("TT",new StoryBlank("TT"));
        blanks.put("UU",new StoryBlank("UU"));
        blanks.put("VV",new StoryBlank("VV"));
        blanks.put("XX",new StoryBlank("XX"));
        blanks.put("YY",new StoryBlank("YY"));
        blanks.put("ZZ",new StoryBlank("ZZ"));

        return blanks;
    }
}