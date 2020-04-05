package com.example.make_a_story_prototype.main.data.Story.test_data;

import com.example.make_a_story_prototype.R;
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

public class Data_TheSpecialInvention {
    public static Story sampleStory() {
        List<StoryPage> pages = new ArrayList<>();
        pages.add(sampleStoryPage1());

        return new Story(0,"The Special Invention", pages, R.drawable.story_special_invention_compressed);
    }

    private static StoryPage sampleStoryPage1() {
        List<StorySegment> segments = new ArrayList<>();

        segments.add(new StoryText("\"Get dressed and come to breakfast right now!\" Mom called sweetly.\n"
                + "\t\"I will,\" ", R.raw.special_invention_segment_1));
        segments.add(new StoryBlankIdentifier("A-2"));
        segments.add(new StoryText(" said.\n"
                + "\t\"You said that twice already! You’ll make me late for work.\"\n"
                + "\t\"Okay!\"  ", R.raw.special_invention_segment_2));
        segments.add(new StoryBlankIdentifier("A-2"));
        segments.add(new StoryText(" said.\n\n" +
                "\tGreat ideas kept ", R.raw.special_invention_segment_3));
        segments.add(new StoryBlankIdentifier("A-2"));
        segments.add(new StoryText(" thinking till late at night, so every morning it " +
                "was hard to wake up in time for school.\n\n\t", R.raw.special_invention_segment_4));
        segments.add(new StoryBlankIdentifier("A-2"));
        segments.add(new StoryText(" liked inventing things, and they always worked " +
                "really well --- while ", R.raw.special_invention_segment_5));
        segments.add(new StoryBlankIdentifier("A-2"));
        segments.add(new StoryText(" was planning and imagining them --- and " +
                "sometimes almost worked after ", R.raw.special_invention_segment_6));
        segments.add(new StoryBlankIdentifier("A-2"));
        segments.add(new StoryText(" actually made them. A funnel to toss toys " +
                "in like the ", R.raw.special_invention_segment_7));
        segments.add(new StoryBlankIdentifier("BB"));
        segments.add(new StoryText(" and the ", R.raw.special_invention_segment_8));
        segments.add(new StoryBlankIdentifier("CC"));
        segments.add(new StoryText(" so they’d slide into the toy box to save time cleaning up. "
                + "A squirt-gun scraper to scrape dog poop off shoes and wash them at the same time. "
                + "A special second string so a kite could drop a little parachute holding a toy ", R.raw.special_invention_segment_9));
        segments.add(new StoryBlankIdentifier("DD"));
        segments.add(new StoryText(".\n\n\tInteresting inventions. Helpful inventions! Wonderful inventions!!\n\n\t", R.raw.special_invention_segment_10));
        segments.add(new StoryBlankIdentifier("A-2"));
        segments.add(new StoryText(" needed a special stay-up-after-wake-up-in-the-morning invention. ", R.raw.special_invention_segment_11));
        segments.add(new StoryBlankIdentifier("A-2"));
        segments.add(new StoryText(" thought about the ", R.raw.special_invention_segment_12));
        segments.add(new StoryBlankIdentifier("EE"));
        segments.add(new StoryText(" part all through breakfast, and cogitated about the ", R.raw.special_invention_segment_13));
        segments.add(new StoryBlankIdentifier("FF"));
        //2 lines below commented out bc of missing audio
        //segments.add(new StoryText(" and the ", R.raw.special_invention_segment_??));
        //segments.add(new StoryBlankIdentifier("GG"));
        segments.add(new StoryText(" section on the way to school, and devised the ", R.raw.special_invention_segment_14));
        segments.add(new StoryBlankIdentifier("JJ"));
        segments.add(new StoryText(" unit at school, and imagined the ", R.raw.special_invention_segment_15));
        segments.add(new StoryBlankIdentifier("KK"));
        segments.add(new StoryText(" segment on the way home, and by after school snack time knew the ", R.raw.special_invention_segment_16));
        segments.add(new StoryBlankIdentifier("LL"));
        segments.add(new StoryText(" made the final step and then knew exactly how to " +
                "create it!\n\n\tEvery morning on her way to the kitchen Mom opened the bedroom door " +
                "to politely say, \"Wake up!\"\n\n\t", R.raw.special_invention_segment_17)); // TODO: special_invention_segment_17 has mistake. Fix the audio
        segments.add(new StoryBlankIdentifier("A-2"));
        segments.add(new StoryText(" tied a string to the door knob, so when the door " +
                "opened it would drop a toy ", R.raw.special_invention_segment_18));
        segments.add(new StoryBlankIdentifier("EE"));
        segments.add(new StoryText(" on a teeter-totter lever tossing a toy ", R.raw.special_invention_segment_19));
        segments.add(new StoryBlankIdentifier("GG"));
        segments.add(new StoryText(" up in the air to flip over and land in a box on top of a toy ", R.raw.special_invention_segment_20));
        segments.add(new StoryBlankIdentifier("JJ"));
        segments.add(new StoryText(" that would tip to roll down a ramp and knock loose the ", R.raw.special_invention_segment_21));
        segments.add(new StoryBlankIdentifier("KK"));
        segments.add(new StoryText(" hooked to the stopper on an old plastic bottle " +
                "filled with water that would slowly start trickling into a bucket with its " +
                "handle rubber-banded to a stick taped to a toy ", R.raw.special_invention_segment_22));
        segments.add(new StoryBlankIdentifier("LL"));
        segments.add(new StoryText(" taped to a sharp pin on the end that would swing up " +
                "to smack and pop a balloon that would for sure startle awake even sleepy ", R.raw.special_invention_segment_23));
        segments.add(new StoryBlankIdentifier("A-2"));
        segments.add(new StoryText(".\n\n\tWho could sleep after creating such a magnificatious, " +
                "splendificatory, brilliastonishing, phenomitastic invention?! Not ", R.raw.special_invention_segment_24));
        segments.add(new StoryBlankIdentifier("A-2"));
        segments.add(new StoryText(", not until very late. "
                + "Too late.\n\n\t", R.raw.special_invention_segment_25));
        segments.add(new StoryBlankIdentifier("A-2"));
        segments.add(new StoryText(" didn’t wake when Mom opened the door and gently " +
                "suggested, \"Wake up!\" Didn’t notice the toy ", R.raw.special_invention_segment_26));
        segments.add(new StoryBlankIdentifier("EE"));
        segments.add(new StoryText(" dropping on the teeter-totter lever that tossed the toy ", R.raw.special_invention_segment_27));
        segments.add(new StoryBlankIdentifier("GG"));
        segments.add(new StoryText(" up into the air to flip and land on the ", R.raw.special_invention_segment_28));
        segments.add(new StoryBlankIdentifier("JJ"));
        segments.add(new StoryText(" so hard that it slipped off the track but still bumped the ", R.raw.special_invention_segment_29));
        segments.add(new StoryBlankIdentifier("KK"));
        segments.add(new StoryText(" loose, only smacking the stopper so hard the water " +
                "didn’t trickle out but shot out like a squirt gun and soaked a toy stuffed ", R.raw.special_invention_segment_30));
        segments.add(new StoryBlankIdentifier("NN"));
        segments.add(new StoryText(" on the edge of the shelf that got so wet heavy it " +
                "fell on the cat that startled and screeched and leaped up high and knocked its hindquarters into the ", R.raw.special_invention_segment_31));
        segments.add(new StoryBlankIdentifier("LL"));
        segments.add(new StoryText(" .So the pin sharp stung the cat’s tail and it howled " +
                "and claw snatched at the balloon that loud-popped, scaring the cat to twist land " +
                "slap on guess-whose sleeping face. \n\n\t", R.raw.special_invention_segment_32));
        segments.add(new StoryBlankIdentifier("A-2"));
        segments.add(new StoryText(" swiped the cat away and jolted straight up and looked " +
                "at the disrupted contraption — and thought: \"Even if everything didn’t go " +
                "exactly perfectly according to plan, my stay-up-after-wake-up-in-the-morning " +
                "invention worked!\"  And it did!",R.raw.special_invention_segment_33));

        return new StoryPage(R.drawable.story_special_invention, segments);
    }

    private static Map<String, StoryBlank> blanks() {
        Map<String, StoryBlank> blanks = new HashMap<>();

        blanks.put("A-2", new StoryBlank("A-2"));
        blanks.put("BB",new StoryBlank("BB"));
        blanks.put("CC",new StoryBlank("CC"));
        blanks.put("DD",new StoryBlank("DD"));
        blanks.put("EE",new StoryBlank("EE"));
        blanks.put("GG",new StoryBlank("GG"));
        blanks.put("JJ",new StoryBlank("JJ"));
        blanks.put("KK",new StoryBlank("KK"));
        blanks.put("LL",new StoryBlank("LL"));
        blanks.put("NN",new StoryBlank("NN"));

        return blanks;
    }
}
