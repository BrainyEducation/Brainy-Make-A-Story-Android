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

public class Data_SantasMixedUpHelperElf {
    public static Story sampleStory() {
        List<StoryPage> pages = new ArrayList<>();
        pages.add(sampleStoryPage1());
        pages.add(sampleStoryPage2());
        pages.add(sampleStoryPage3());

        return new Story(3,"Santa's Mixed-Up Helper Elf", pages);
    }

    private static StoryPage sampleStoryPage1() {
        List<StorySegment> segments = new ArrayList<>();

        segments.add(new StoryText("Late one Christmas Eve, frazzled and exhausted and sleepy-tired more "
                + "than ever, poor shy Elmer, one of Santa’s helper-elves, began climbing into his top bunk-bed "
                + "bed when a paper stuck in his sleeve fluttered at his wrist.  Uh-oh.  He checked.  Uh-oh.  A "
                + "list of toys he’d forgotten to pack up in Santa’s sleigh.  A mother had written and mailed to "
                + "Santa the list for her children at a homeless shelter, a place families go when they can’t stay "
                + "in their own home any more and don’t have any place else to go.  Staying there means they don’t "
                + "have much room, and usually can’t bring more than just one little toy.\n"
                + "\tThe letter she sent for them to Santa said that —", R.raw.santas_helper_elf_segment_1));
        segments.add(new StoryBlankIdentifier("A-2"));
        segments.add(new StoryText(" wanted first a soft fluffy stuffed ", R.raw.santas_helper_elf_segment_2));
        segments.add(new StoryBlankIdentifier("DD"));
        segments.add(new StoryText(" little enough to carry anywhere, and second a wooden ", R.raw.santas_helper_elf_segment_3));
        segments.add(new StoryBlankIdentifier("EE"));
        segments.add(new StoryText(" big enough to sit and rock on and pretend to ride far away. \n"
                + "\t—The first request for  ", R.raw.santas_helper_elf_segment_4));
        segments.add(new StoryBlankIdentifier("B-2"));
        segments.add(new StoryText(" was a ", R.raw.santas_helper_elf_segment_5));
        segments.add(new StoryBlankIdentifier("GG"));
        segments.add(new StoryText(" like nobody else’s, and second a battery powered remote control ", R.raw.santas_helper_elf_segment_6));
        segments.add(new StoryBlankIdentifier("JJ"));
        segments.add(new StoryText(" to race across the floor and under chairs and tables and maybe chase a "
                + "cat or scare-bump somebody’s shoes from behind.\n\t— ", R.raw.santas_helper_elf_segment_7));
        segments.add(new StoryBlankIdentifier("C-2"));
        segments.add(new StoryText(" wanted a brand new ", R.raw.santas_helper_elf_segment_8));
        segments.add(new StoryBlankIdentifier("KK"));
        segments.add(new StoryText(" to show off and look pretty with, and a pretty white sweater with a picture "
                + "of her very favorite animal, a ", R.raw.santas_helper_elf_segment_9));
        segments.add(new StoryBlankIdentifier("LL"));
        segments.add(new StoryText("Timid helper-elf Elmer felt terribly, horribly awful that he’d found the "
                + "list so late and quickly raced around Santa’s big toy warehouse to gather the gifts, but poor "
                + "Elmer’s sleepy eyes didn’t read the list’s words very well, and poor Elmer’s sleepy memory didn’t "
                + "remember very well, and— oh no!— at the very last minute poor timid Elmer had mistakenly loaded "
                + "into Santa’s sleigh—", R.raw.santas_helper_elf_segment_10));

        return new StoryPage(R.drawable.story_santas_elf_1, segments);
    }

    private static StoryPage sampleStoryPage2() {
        List<StorySegment> segments = new ArrayList<>();

        // TODO audio segment split across pages
        segments.add(new StoryText("- for ", R.raw.santas_helper_elf_segment_10));
        segments.add(new StoryBlankIdentifier("A-2"));
        segments.add(new StoryText(" -uh oh–a soft fluffy stuffed little ", R.raw.santas_helper_elf_segment_11));
        segments.add(new StoryBlankIdentifier("RR"));
        segments.add(new StoryText(" to carry and a big wooden ", R.raw.santas_helper_elf_segment_12));
        segments.add(new StoryBlankIdentifier("SS"));
        segments.add(new StoryText(" to ride,\n" +
                "\t— for ", R.raw.santas_helper_elf_segment_13));
        segments.add(new StoryBlankIdentifier("B-2"));
        segments.add(new StoryText(" -uh uh oh–an RC ", R.raw.santas_helper_elf_segment_14));
        segments.add(new StoryBlankIdentifier("VV"));
        segments.add(new StoryText(" and ", R.raw.santas_helper_elf_segment_15));
        segments.add(new StoryBlankIdentifier("WW"));
        segments.add(new StoryText("- for ", R.raw.santas_helper_elf_segment_16));
        segments.add(new StoryBlankIdentifier("C-2"));
        segments.add(new StoryText(" -oh no–  one ", R.raw.santas_helper_elf_segment_17));
        segments.add(new StoryBlankIdentifier("XX"));
        segments.add(new StoryText(" and a pink sweater with a ", R.raw.santas_helper_elf_segment_18));
        segments.add(new StoryBlankIdentifier("YY"));
        segments.add(new StoryText(".\n"
                + "\tSanta, just a tiny bit late as usual, loudly called out ‘Hi Ho’ and his team of reindeer swooshed "
                + "off into the sky just at the very moment when poor timid Elmer looked at that list one more time—uh oh— "
                + "and discovered —oh no!— he had made a mistake on every …  single … gift.  Elmer crumpled down on the floor "
                + "and wanted to cry, because nothing hurts and saddens and breaks a helper-elf’s heart more than not making a "
                + "child happy.  And sometimes they just can’t.  Poor Elmer felt so terrible he didn’t even want to think about "
                + "it, and after a few minutes of feeling sad and horrible and not liking himself at all, the tired, exhausted "
                + "little helper elf nodded off to sleep.\n"
                + "\tOn Christmas morning poor timid Elmer woke up late, not on the warehouse floor where he’d fallen asleep, "
                + "but in his own proper top bunk-bed bed.  Santa held a tray with ", R.raw.santas_helper_elf_segment_19));
        segments.add(new StoryBlankIdentifier("NN"));
        segments.add(new StoryText(" and ", R.raw.santas_helper_elf_segment_20));
        segments.add(new StoryBlankIdentifier("PP"));
        segments.add(new StoryText(" and ", R.raw.santas_helper_elf_segment_21));
        segments.add(new StoryBlankIdentifier("QQ"));
        segments.add(new StoryText("  ---  Elmer’s favorite breakfast.  \n"
                + "\t\"Well, Elmer—\" Santa began. \t\n"
                + "\tElmer cried now.  Ashamed.  Ashamed Santa would treat him so nicely after he had failed the children and "
                + "Santa and Christmas ", R.raw.santas_helper_elf_segment_22));

        return new StoryPage(R.drawable.story_santas_elf_2, segments);
    }

    private static StoryPage sampleStoryPage3() {
        List<StorySegment> segments = new ArrayList<>();
        // TODO: segment split across pages
        segments.add(new StoryText("\"You know,\" Santa said, \"I didn’t bring three children the presents they asked for.\"\n"
                + "\tPoor sad Elmer sobbed and wailed louder than ever.  \n\"", R.raw.santas_helper_elf_segment_22));
        segments.add(new StoryBlankIdentifier("A-2"));
        segments.add(new StoryText("says that ", R.raw.santas_helper_elf_segment_23));
        segments.add(new StoryBlankIdentifier("RR"));
        segments.add(new StoryText(" is boring,\" Santa said, \"and wants nothing to do with it, but really, really "
                + "likes the new ", R.raw.santas_helper_elf_segment_24));
        segments.add(new StoryBlankIdentifier("SS"));
        segments.add(new StoryText(" and rides it everywhere...even to the potty.\n"
                + "\t\"And ", R.raw.santas_helper_elf_segment_25));
        segments.add(new StoryBlankIdentifier("B-2"));
        segments.add(new StoryText(" already has an old ", R.raw.santas_helper_elf_segment_26));
        segments.add(new StoryBlankIdentifier("VV"));
        segments.add(new StoryText(", and won’t play with the new one, but really likes the ", R.raw.santas_helper_elf_segment_27));
        segments.add(new StoryBlankIdentifier("WW"));
        segments.add(new StoryText(" which ", R.raw.santas_helper_elf_segment_28));
        segments.add(new StoryBlankIdentifier("B-2"));
        segments.add(new StoryText(" says is now the very favoritest bestest toy of all.   \n"
                + "\t\"", R.raw.santas_helper_elf_segment_29));
        segments.add(new StoryBlankIdentifier("C-2"));
        segments.add(new StoryText(" likes her pretty new ", R.raw.santas_helper_elf_segment_30));
        segments.add(new StoryBlankIdentifier("XX"));
        segments.add(new StoryText(" well enough, but her mother says she can’t take it outside yet. She "
                + "liked her pink sweater with the ", R.raw.santas_helper_elf_segment_31));
        segments.add(new StoryBlankIdentifier("YY"));
        segments.add(new StoryText(" only okay until everyone said how pretty it is, and now it’s almost "
                + "the only top she ever wants to wear anywhere.\"\n"
                + "\t\"Ohhhh.\"  Elmer said.\n"
                + "\t\"But—the boss at the shelter said she’s sorry, but there’s just not enough room and each "
                + "child can keep only one present.\"\n"
                + "\t\"Oh.....\" Elmer said.\n"
                + "\t\"But three new children came to the shelter.  They didn’t have a home for Santa to visit "
                + "Christmas Eve and on Christmas Day they found no presents at all.\"\n"
                + "\t\"Oh!\"\n"
                + "\t\"So ", R.raw.santas_helper_elf_segment_32));
        segments.add(new StoryBlankIdentifier("A-2"));
        segments.add(new StoryText(" and ", R.raw.santas_helper_elf_segment_33));
        segments.add(new StoryBlankIdentifier("B-2"));
        segments.add(new StoryText(" and ", R.raw.santas_helper_elf_segment_34));
        segments.add(new StoryBlankIdentifier("C-2"));
        segments.add(new StoryText(" gave their extra gifts to those three children who were very surprised, "
                + "and very, very happy and excited to get them\""
                + "\"Oh!!!\" \n \"And ", R.raw.santas_helper_elf_segment_35));
        segments.add(new StoryBlankIdentifier("A-2"));
        segments.add(new StoryText(" and ", R.raw.santas_helper_elf_segment_36));
        segments.add(new StoryBlankIdentifier("B-2"));
        segments.add(new StoryText(" and ", R.raw.santas_helper_elf_segment_37));
        segments.add(new StoryBlankIdentifier("C-2"));
        segments.add(new StoryText(" discovered what you and I have always known.\"\n"
                + "\t\"Oh?\"\n"
                + "\"That getting a gift feels wonderful, but giving to someone who really needs it feels even better.\"\n"
                + "\t\"Oh.\"  Elmer said.  \"Ohhhh.\"", R.raw.santas_helper_elf_segment_38));

        return new StoryPage(R.drawable.story_santas_elf_3, segments);
    }

    private static Map<String, StoryBlank> blanks() {
        Map<String, StoryBlank> blanks = new HashMap<>();

        blanks.put("A-2", new StoryBlank("A-2"));
        blanks.put("B-2", new StoryBlank("B-2"));
        blanks.put("C-2", new StoryBlank("C-2"));
        blanks.put("DD",new StoryBlank("DD"));
        blanks.put("EE",new StoryBlank("EE"));
        blanks.put("GG",new StoryBlank("GG"));
        blanks.put("JJ",new StoryBlank("JJ"));
        blanks.put("KK",new StoryBlank("KK"));
        blanks.put("LL",new StoryBlank("LL"));
        blanks.put("RR",new StoryBlank("RR"));
        blanks.put("SS",new StoryBlank("SS"));
        blanks.put("VV",new StoryBlank("VV"));
        blanks.put("WW",new StoryBlank("WW"));
        blanks.put("XX",new StoryBlank("XX"));
        blanks.put("YY",new StoryBlank("YY"));
        blanks.put("NN",new StoryBlank("NN"));
        blanks.put("PP",new StoryBlank("PP"));
        blanks.put("QQ",new StoryBlank("QQ"));

        return blanks;
    }
}
