package com.example.make_a_story_prototype.main.StoryTemplate.vm;

import com.example.make_a_story_prototype.R;

import java.util.ArrayList;
import java.util.List;

public class StoryPageSampleData {
    static Story sampleStory() {
        List<StoryPage> pages = new ArrayList<>();
        pages.add(sampleStoryPage1());
        pages.add(sampleStoryPage2());
        pages.add(sampleStoryPage3());
        pages.add(sampleStoryPage4());
        pages.add(sampleStoryPage5());

        List<StoryBlank> blanks = new ArrayList<>();
        // TODO:
        addStoryBlanks(blanks);

        return new Story(pages, blanks);
    }

    static StoryPage sampleStoryPage1() {
        List<StorySegment> segments = new ArrayList<>();
        segments.add(new StoryText("One Saturday evening "));
        segments.add(new StoryText(" and "));
        segments.add(new StoryText(" made a tent to camp out in the back yard.  They griped and whined and complained to each other about a school assignment due next week:  to stand in front of the whole class and show pictures and talk about a special place they had visited.  Neither one had any special pictures of any place special, and they both just knew the teacher would embarrass them, and the other kids would tease them, and Monday would be terrifishously, awfulishously, horrifishously bad.  Feeling glum, "));
        segments.add(new StoryText(" snuggled tight in some blankets and "));
        segments.add(new StoryText(" curled up in a sleeping bag, when about midnight a strange-shaped shadow flickered on their tent wall.  \n"
                + "\t\"What’s that” asked "));
        segments.add(new StoryText(".   \"Maybe some "));
        segments.add(new StoryText(".\""));
        segments.add(new StoryText("\" Or a maybe some kind of \""));
        segments.add(new StoryText(",\" guessed "));
        segments.add(new StoryText(" They stuck their noses outside to find a weird looking space alien just their size."));

        return new StoryPage(R.drawable.story_space_alien_1, segments);
    }

    static StoryPage sampleStoryPage2() {
        List<StorySegment> segments = new ArrayList<>();
        segments.add(new StoryText("\"Please help me!\" \n"
                + "\t\"How?\" \t\n"
                + "\t\"For my school project I need pictures of earth stuff, and I took a few pictures but I need more.\"\n"
                + "\t\"Show us.\" \n"
                + "\tSpace Alien punched a shiny elbow button and twisted a fancy shoulder dial, and Space Alien’s tummy screen displayed a glowy"));
        segments.add(new StoryText("\"That’s a strange looking earth planet"));
        segments.add(new StoryText("\"Nope.  Actually, a pretty nice"));
        segments.add(new StoryText("\"No!  Are you sure?\" \n"
                + "\tBoth kids nodded yes. \"But my sister said— I just feel so "));
        segments.add(new StoryText(".  It makes me want to"));
        segments.add(new StoryText(".\""));

        return new StoryPage(R.drawable.story_space_alien_2, segments);
    }

    static StoryPage sampleStoryPage3() {
        List<StorySegment> segments = new ArrayList<>();
        segments.add(new StoryText("\"Well, what about my"));
        segments.add(new StoryText("?\""));
        segments.add(new StoryText("\"Sorry.  But you’ve got a really nice "));
        segments.add(new StoryText("\"I’ll fail my school project!\" \n"
                + "\t\"No way!  We’ll help.\"\t\t\n"
                + "\t\"What kinds of pictures do you need?\"  \t\t\n"
                + "\t\"Anything!  Everything!\"\n"
                + "\tWhile everyone else in the house slept tight, the kids showed Space Alien lots of things—some toys, some real.\n"));

        return new StoryPage(R.drawable.story_space_alien_3, segments);
    }

    static StoryPage sampleStoryPage4() {
        List<StorySegment> segments = new ArrayList<>();
        segments.add(new StoryText("\""));
        segments.add(new StoryText(",  I’m sure!  My big brother told me.\"\n"
                + "\t\""));
        segments.add(new StoryText(".   Big brother must have been teasing.  Guess this.\"\n"
                + "\t\""));
        segments.add(new StoryText(".  Absolutely positively!\"\n"
                + "\t\"Nope,\" \""));
        segments.add(new StoryText(".\"\n"
                + "\tThen Space Alien started to "));
        segments.add(new StoryText("  and "));
        segments.add(new StoryText(".  \n"
                + "\t\"Why are you doing that?\"\n"
                + "\t\"That’s how we show we’re confused on my planet.\"\n"
                + "\t\"We mostly just scratch our heads.\"\n"
                + "\t\"What do you do when you’re angry?\"\n"
                + "\t\""));
        segments.add(new StoryText(".\""));
        segments.add(new StoryText("\"And when you’re happy?\"\n"
                + "\t\"Mostly we"));
        segments.add(new StoryText(".\""));
        segments.add(new StoryText(" and "));
        segments.add(new StoryText("  just shook their heads.\n"
                + "\t\"Want to ride along while I check out some more freaky strange stuff?\"\n"
                + "\t\"Sure!\" \t\t\t \n"
                + "\tSpace Alien clicked heels, and a weird unearthly contraption quick-scooted over and hovered in the air beside their ankles. "));

        return new StoryPage(R.drawable.story_space_alien_4, segments);
    }

    static StoryPage sampleStoryPage5() {
        List<StorySegment> segments = new ArrayList<>();
        segments.add(new StoryText("\"What a great skateboard!\" \t \n"
                + "\t\"Fantabulously SUPER skateboard!\" \t \n"
                + "\t\"Space-board!\" \n"
                + " \tAll three hopped on and flew away soaring high over a big "));
        segments.add(new StoryText(" and an even bigger "));
        segments.add(new StoryText(", curly-cueing around some "));
        segments.add(new StoryText(" and nearly knocking over an in-the-way "));
        segments.add(new StoryText("  Space Alien snapped picture after picture, "));
        segments.add(new StoryText(" and "));
        segments.add(new StoryText(" and "));
        segments.add(new StoryText(" and "));
        segments.add(new StoryText(".\n"
                + "\t\"That’s enough.  Thanks for helping me do the best school project ever!\" \n"
                + "\t\"Glad to help.  But you know—\"\n"
                + "\t\"What?\" \n"
                + "\t\"We’ve got our own school project due next week.\"\n"
                + "\t\"About some place we’d like to visit.\"\n"
                + "\t\"Do you think, maybe—\"\n"
                + "\t\"Maybe—\"\n"
                + "\t\"I’ll be back same time tomorrow night!  Bring your cameras!\"\n"
                + "\tAnd they did!\t"));

        return new StoryPage(R.drawable.story_space_alien_5, segments);
    }

    private static void addStoryBlanks(List<StoryBlank> blanks) {
        // page 1
        blanks.add(new StoryBlank(new StoryBlankIdentifier("A-2")));
        blanks.add(new StoryBlank(new StoryBlankIdentifier("C-2")));
        blanks.add(new StoryBlank(new StoryBlankIdentifier("A-2")));
        blanks.add(new StoryBlank(new StoryBlankIdentifier("C-2")));
        blanks.add(new StoryBlank(new StoryBlankIdentifier("A-2")));
        blanks.add(new StoryBlank(new StoryBlankIdentifier("AA")));
        blanks.add(new StoryBlank(new StoryBlankIdentifier("BB")));
        blanks.add(new StoryBlank(new StoryBlankIdentifier("C-2")));

        // page 2
        blanks.add(new StoryBlank(new StoryBlankIdentifier("CC")));
        blanks.add(new StoryBlank(new StoryBlankIdentifier("DD")));
        blanks.add(new StoryBlank(new StoryBlankIdentifier("CC")));
        blanks.add(new StoryBlank(new StoryBlankIdentifier("FF")));
        blanks.add(new StoryBlank(new StoryBlankIdentifier("GG")));

        // page 3
        blanks.add(new StoryBlank(new StoryBlankIdentifier("HH")));
        blanks.add(new StoryBlank(new StoryBlankIdentifier("JJ")));

        // page 4
        blanks.add(new StoryBlank(new StoryBlankIdentifier("KK")));
        blanks.add(new StoryBlank(new StoryBlankIdentifier("LL")));
        blanks.add(new StoryBlank(new StoryBlankIdentifier("MM")));
        blanks.add(new StoryBlank(new StoryBlankIdentifier("NN")));
        blanks.add(new StoryBlank(new StoryBlankIdentifier("OO")));
        blanks.add(new StoryBlank(new StoryBlankIdentifier("PP")));
        blanks.add(new StoryBlank(new StoryBlankIdentifier("QQ")));
        blanks.add(new StoryBlank(new StoryBlankIdentifier("RR")));
        blanks.add(new StoryBlank(new StoryBlankIdentifier("A-2")));
        blanks.add(new StoryBlank(new StoryBlankIdentifier("C-2")));

        // page 5
        blanks.add(new StoryBlank(new StoryBlankIdentifier("SS")));
        blanks.add(new StoryBlank(new StoryBlankIdentifier("TT")));
        blanks.add(new StoryBlank(new StoryBlankIdentifier("UU")));
        blanks.add(new StoryBlank(new StoryBlankIdentifier("VV")));
        blanks.add(new StoryBlank(new StoryBlankIdentifier("XX")));
        blanks.add(new StoryBlank(new StoryBlankIdentifier("YY")));
        blanks.add(new StoryBlank(new StoryBlankIdentifier("ZZ")));
    }
}