package com.example.make_a_story_prototype.main.data.Story.test_data;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.data.Story.model.ImageLocation;
import com.example.make_a_story_prototype.main.data.Story.model.Story;
import com.example.make_a_story_prototype.main.data.Story.model.StoryBlank;
import com.example.make_a_story_prototype.main.data.Story.model.StoryBlankIdentifier;
import com.example.make_a_story_prototype.main.data.Story.model.StoryPage;
import com.example.make_a_story_prototype.main.data.Story.model.StorySegment;
import com.example.make_a_story_prototype.main.data.Story.model.StoryText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data_TheWackyCostumeParty {
    public static Story sampleStory() {
        List<StoryPage> pages = new ArrayList<>();
        pages.add(sampleStoryPage1());
        pages.add(sampleStoryPage2());

        return new Story(2,"The Wacky Costume Party", pages, R.drawable.story_wacky_party_background);
    }

    private static StoryPage sampleStoryPage1() {
        List<StorySegment> segments = new ArrayList<>();
        //First paragraph
        segments.add(new StoryText("\tDo you like wearing costumes and pretending to be " +
                "somebody different?  The spelling kids really do, and enjoyed the goofiest, " +
                "silliest, craziest, wackiest mixed-up costume party ever!  And had their pets " +
                "dress up too!  The only rule was—no scary costumes.  Some kids dressed like " +
                "a ", R.raw.wacky_costume_segment_1));
        segments.add(new StoryBlankIdentifier("AA"));
        segments.add(new StoryText(" or ", R.raw.wacky_costume_segment_2));
        segments.add(new StoryBlankIdentifier("BB"));
        segments.add(new StoryText(" or ", R.raw.wacky_costume_segment_3));
        segments.add(new StoryBlankIdentifier("CC"));
        segments.add(new StoryText(", but the spelling kids shared and traded different " +
                "costume parts so they all looked really strange and weird and kind of " +
                "especially — wondersome!  Except — ", R.raw.wacky_costume_segment_4));
        segments.add(new StoryBlankIdentifier("C-2"));
        segments.add(new StoryText(" didn’t plan to mean to intend to break the rule, or " +
                "be really naughty, just maybe a tiny bit mischievous, " +
                "so ", R.raw.wacky_costume_segment_5));
        segments.add(new StoryBlankIdentifier("C-2"));
        segments.add(new StoryText(" convinced ",R.raw.wacky_costume_segment_6));
        segments.add(new StoryBlankIdentifier("C-2"));
        segments.add(new StoryText(" it would be okay if the costume wasn’t scary " +
                "all by itself, only just scary if people decided to be frightened, and " +
                "if people decided to, ", R.raw.wacky_costume_segment_7));
        segments.add(new StoryBlankIdentifier("C-2"));
        segments.add(new StoryText(" decided that ",R.raw.wacky_costume_segment_8));
        segments.add(new StoryBlankIdentifier("C-2"));
        segments.add(new StoryText(" wasn't to blame. Uh-hunh. \n\n\t",
                R.raw.wacky_costume_segment_9));
//         //Second Paragraph
//        segments.add(new StoryBlankIdentifier("D-2"));
//        segments.add(new StoryText(" went to the party as a ",R.raw.wacky_costume_segment_10));
//        segments.add(new StoryBlankIdentifier("DD"));
//        segments.add(new StoryText(" — and brought a pet ",R.raw.wacky_costume_segment_11));
//        segments.add(new StoryBlankIdentifier("FF"));
//        segments.add(new StoryText(" who looked very interesting with a ",
//                R.raw.wacky_costume_segment_12));
//        segments.add(new StoryBlankIdentifier("GG"));
//        segments.add(new StoryText(" body and a ",R.raw.wacky_costume_segment_13));
//        // SWITCHING BODY & TAIL TO CORRESPOND TO SAME ID
//        segments.add(new StoryBlankIdentifier("GG"));
//        segments.add(new StoryText(" tail.\n\n\t",R.raw.wacky_costume_segment_14));
//        // Third Paragraph
//        segments.add(new StoryBlankIdentifier("G-2"));
//        segments.add(new StoryText(" came costumed as a ",R.raw.wacky_costume_segment_15));
//        segments.add(new StoryBlankIdentifier("II"));
//        segments.add(new StoryText(", and had a pet ",R.raw.wacky_costume_segment_16));
//        segments.add(new StoryBlankIdentifier("KK"));
//        segments.add(new StoryText(" who looked great with a ",R.raw.wacky_costume_segment_17));
//        segments.add(new StoryBlankIdentifier("LL"));
//        segments.add(new StoryText(" tail and a ",R.raw.wacky_costume_segment_18));
//        // SWITCHING BODY & TAIL TO CORRESPOND TO SAME ID
//        segments.add(new StoryBlankIdentifier("LL"));
//        segments.add(new StoryText(" middle.\n\n\t",R.raw.wacky_costume_segment_19));
//        // Fourth Paragraph
//        segments.add(new StoryBlankIdentifier("K-2"));
//        segments.add(new StoryText(" thought and wondered and cogitated and finally " +
//                "decided to be a ",R.raw.wacky_costume_segment_20));
//        segments.add(new StoryBlankIdentifier("NN"));
//        segments.add(new StoryText(" and brought a strange pet ",
//                R.raw.wacky_costume_segment_21));
//        segments.add(new StoryBlankIdentifier("PP"));
//        segments.add(new StoryText(" with ", R.raw.wacky_costume_segment_22));
//        segments.add(new StoryBlankIdentifier("QQ"));
//        segments.add(new StoryText(" tummy parts and a ", R.raw.wacky_costume_segment_23));
//        // SWITCHING BODY & TAIL TO CORRESPOND TO SAME ID
//        segments.add(new StoryBlankIdentifier("QQ"));
//        //Leads to the beginning of second page
//        segments.add(new StoryText(" tail part.\n\n\tAnd a wonderful time was had by all " +
//                "— until ", R.raw.wacky_costume_segment_24));

        Map<String, ImageLocation> imageLocations = new HashMap<>();

        imageLocations.put("AA", null);
        imageLocations.put("BB", null);
        imageLocations.put("CC", null);
        imageLocations.put("C-2", null);

        imageLocations.put("D-2", null); // costume DD
        imageLocations.put("DD", new ImageLocation("DD", 40f, 20f, 200, 200, 0));
        imageLocations.put("FF", null); // D-2's pet
        imageLocations.put("GG", new ImageLocation("GG", 30f, 30f, 150, 200, 0)); // costume for FF (D-2's pet)

        imageLocations.put("G-2", null); // costume II
        imageLocations.put("II", new ImageLocation("II", 69f, 26f, 200, 200, 0));
        imageLocations.put("KK", null); // G-2's pet
        imageLocations.put("LL", new ImageLocation("LL", 65f, 75f, 150, 150, 0)); // costume for KK (G-2's pet)

        imageLocations.put("K-2", null); // costume NN
        imageLocations.put("NN", new ImageLocation("NN", 82f, 36f, 200, 200, 0));
        imageLocations.put("PP", null); // K-2's pet
        imageLocations.put("QQ", new ImageLocation("QQ", 76f, 56f, 150, 150, 0)); // costume for PP (K-2's pet)
        imageLocations.put("G-2", null);



        return new StoryPage(R.drawable.story_wacky_costume_1, segments, imageLocations);
    }


    private static StoryPage sampleStoryPage2() {
        List<StorySegment> segments = new ArrayList<>();

        //TODO: text segment 24 broken across 2 pages
        //First/only paragraph (Beginning few words are at the end of last page.)
        segments.add(new StoryBlankIdentifier("C-2"));
        segments.add(new StoryText(" appeared in a Bigfoot Sasquatch costume! " +
                "Which didn’t scare ", R.raw.wacky_costume_segment_25));
        segments.add(new StoryBlankIdentifier("D-2"));
        segments.add(new StoryText(" or ",R.raw.wacky_costume_segment_26));
        segments.add(new StoryBlankIdentifier("G-2"));
        segments.add(new StoryText(" or ",R.raw.wacky_costume_segment_27));
        segments.add(new StoryBlankIdentifier("K-2"));
        segments.add(new StoryText(" — they didn’t decide to be frightened — but " +
                "those poor pets didn’t know they could decide, and just got howlishously " +
                "scared without even thinking about it. The ",R.raw.wacky_costume_segment_28));
        segments.add(new StoryBlankIdentifier("FF"));
        segments.add(new StoryText(" spilled the fruit punch bowl and the ",
                R.raw.wacky_costume_segment_29));
        segments.add(new StoryBlankIdentifier("KK"));
        segments.add(new StoryText(" tumbled into the big party chocolate angel-food " +
                "cake and the ", R.raw.wacky_costume_segment_30));
        segments.add(new StoryBlankIdentifier("PP"));
        segments.add(new StoryText(" knocked over the treats table and in all the " +
                "commotion ", R.raw.wacky_costume_segment_31));
        segments.add(new StoryBlankIdentifier("D-2"));
        segments.add(new StoryText(" hid behind the ", R.raw.wacky_costume_segment_32));
        segments.add(new StoryBlankIdentifier("SS"));
        segments.add(new StoryText(", and ", R.raw.wacky_costume_segment_33));
        segments.add(new StoryBlankIdentifier("G-2"));
        segments.add(new StoryText(" peeked out of the ", R.raw.wacky_costume_segment_34));
        segments.add(new StoryBlankIdentifier("TT"));
        segments.add(new StoryText(", and ", R.raw.wacky_costume_segment_35));
        segments.add(new StoryBlankIdentifier("K-2"));
        segments.add(new StoryText(" sneaked under the ", R.raw.wacky_costume_segment_36));
        segments.add(new StoryBlankIdentifier("UU"));
        segments.add(new StoryText(", and when the grown-ups rushed in ",
                R.raw.wacky_costume_segment_37));
        segments.add(new StoryBlankIdentifier("C-2"));
        segments.add(new StoryText(" thought it was a very good time to hide in a " +
                "costume, only maybe not in a Bigfoot Sasquatch costume.  And the grownups " +
                "made ", R.raw.wacky_costume_segment_38));
        segments.add(new StoryBlankIdentifier("C-2"));
        segments.add(new StoryText(" keep that costume on and do all the work all alone " +
                "to wipe up the fruit punch and clean up the spilled cake and tidy up the " +
                "treats table.  And ", R.raw.wacky_costume_segment_39));
        segments.add(new StoryBlankIdentifier("C-2"));
        segments.add(new StoryText(" decided not to decide again that it would be okay " +
                "fun to decide to scare anybody, whether they decided to be scared or not. ",
                R.raw.wacky_costume_segment_40));


        Map<String, ImageLocation> imageLocations = new HashMap<>();

        // characters (costumed)
        imageLocations.put("C-2", null);
        imageLocations.put("D-2", new ImageLocation("DD", 0f, 53f, 200, 200, 0)); // behind SS
        imageLocations.put("G-2", new ImageLocation("II", 70f, 68f, 200, 200, 0)); // peeking out of TT
        imageLocations.put("K-2", new ImageLocation("NN", 83f, 68f, 200, 200, 0)); // under UU

        // pets (costumed)
        imageLocations.put("FF", new ImageLocation("GG", 40f, 13f, 150, 150, 0));
        imageLocations.put("KK", new ImageLocation("LL", 25f, 22f, 150, 150, 0));
        imageLocations.put("PP", new ImageLocation("QQ", 30f, 50f, 150, 150, 0));

        // other scene objects
        imageLocations.put("SS", new ImageLocation("SS", 0f, 75f, 150, 150, 0));
        imageLocations.put("TT", null); // no spot in scene image
        imageLocations.put("UU", new ImageLocation("UU", 80f, 50f, 150, 150, 0));

        return new StoryPage(R.drawable.story_wacky_costume_2, segments, imageLocations);
    }

    private static Map<String, StoryBlank> blanks() {
        Map<String, StoryBlank> blanks = new HashMap<>();

        blanks.put("C-2", new StoryBlank("C-2"));
        blanks.put("D-2", new StoryBlank("D-2"));
        blanks.put("G-2", new StoryBlank("G-2"));
        blanks.put("K-2", new StoryBlank("K-2"));
        blanks.put("AA",new StoryBlank("AA"));
        blanks.put("BB",new StoryBlank("BB"));
        blanks.put("CC",new StoryBlank("CC"));
        blanks.put("DD",new StoryBlank("DD"));
        blanks.put("FF",new StoryBlank("FF"));
        blanks.put("GG",new StoryBlank("GG"));
        blanks.put("HH",new StoryBlank("HH"));
        blanks.put("II",new StoryBlank("II"));
        blanks.put("KK",new StoryBlank("KK"));
        blanks.put("LL",new StoryBlank("LL"));
        blanks.put("MM",new StoryBlank("MM"));
        blanks.put("NN",new StoryBlank("NN"));
        blanks.put("PP",new StoryBlank("PP"));
        blanks.put("QQ",new StoryBlank("QQ"));
        blanks.put("RR",new StoryBlank("RR"));
        blanks.put("SS",new StoryBlank("SS"));
        blanks.put("TT",new StoryBlank("TT"));
        blanks.put("UU",new StoryBlank("UU"));

        return blanks;
    }
}
