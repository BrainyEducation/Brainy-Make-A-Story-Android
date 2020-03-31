package com.example.make_a_story_prototype.main.data.StorySegments;

import com.example.make_a_story_prototype.main.StoryTemplate.model.StoryBlank;

import java.util.ArrayList;
import java.util.List;

public class DebugStorySegmentsRepository implements StorySegmentsRepository {
    private Story spaceAlien = new Story(1, "The Space Alien");
    private Story specialInvention = new Story(2, "The Special Invention");
    private Story wackyCostumeParty = new Story(3, "The Wacky Costume Party ");
    private Story mixedUpHelperElf = new Story(4, "Santa's Mixed-up Helper Elf");

    private Story[] stories = {
            spaceAlien,
            specialInvention,
            wackyCostumeParty,
            mixedUpHelperElf
    };

    private TextSegment[] textSegments = {
            // page 1
            new TextSegment(1, 1,"One Saturday evening "),
            new TextSegment(1, 1," and "),
            new TextSegment(1, 1," made a tent to camp out in the back "
                    + "yard.  They griped and whined and complained to each other about a school "
                    + "assignment due next week:  to stand in front of the whole class and show "
                    + "pictures and talk about a special place they had visited.  Neither one had "
                    + "any special pictures of any place special, and they both just knew the "
                    + "teacher would embarrass them, and the other kids would tease them, and Monday "
                    + "would be terrifishously, awfulishously, horrifishously bad.  "
                    + "Feeling glum, "),
            new TextSegment(1, 1," snuggled tight in some blankets and "),
            new TextSegment(1, 1," curled up in a sleeping bag, when about "
                    + "midnight a strange-shaped shadow flickered on their tent wall.  \n"
                    + "\t\"What’s that” asked "),
            new TextSegment(1, 1,".   \"Maybe some "),
            new TextSegment(1, 1,".\""),
            new TextSegment(1, 1,"\" Or a maybe some kind of \""),
            new TextSegment(1, 1,",\" guessed "),
            new TextSegment(1, 1," They stuck their noses outside to find a "
                    + "weird looking space alien just their size."),
            // page 2
            new TextSegment(1, 2,"\"Please help me!\" \n"
                    + "\t\"How?\" \t\n"
                    + "\t\"For my school project I need pictures of earth stuff, and I took a few pictures but I need more.\"\n"
                    + "\t\"Show us.\" \n"
                    + "\tSpace Alien punched a shiny elbow button and twisted a fancy shoulder dial, and Space Alien’s tummy screen displayed a glowy"),
            new TextSegment(1, 2," and "),
            new TextSegment(1, 2,"\"That’s a strange looking earth planet"),
            new TextSegment(1, 2,"\"Nope.  Actually, a pretty nice"),
            new TextSegment(1, 2,"\"No!  Are you sure?\" \n"
                    + "\tBoth kids nodded yes. \"But my sister said— I just feel so "),
            new TextSegment(1, 2,".  It makes me want to"),
            new TextSegment(1, 2,".\""),
            // page 3
            new TextSegment(1, 3,"\"Well, what about my "),
            new TextSegment(1, 3,"?\" "),
            new TextSegment(1, 3,"\"Sorry.  But you’ve got a really nice "),
            new TextSegment(1, 3,".\" "),
            new TextSegment(1, 3,"\"I’ll fail my school project!\" \n"
                    + "\t\"No way!  We’ll help.\"\t\t\n"
                    + "\t\"What kinds of pictures do you need?\"  \t\t\n"
                    + "\t\"Anything!  Everything!\"\n"
                    + "\tWhile everyone else in the house slept tight, the kids showed Space Alien lots of things—some toys, some real.\n"),
            // page 4
            new TextSegment(1, 4,"\""),
            new TextSegment(1, 4,", I’m sure! My big brother told me.”\n\""
                    + "\t\""),
            new TextSegment(1, 4,". Big brother must have been teasing.  Guess this.\"\n"
                    + "\t\""),
            new TextSegment(1, 4,".  Absolutely positively!\"\n"
                    + "\t\"Nope,\" \""),
            new TextSegment(1, 4,".\""),
            new TextSegment(1, 4,"Then Space Alien started to "),
            new TextSegment(1, 4,"  and "),
            new TextSegment(1, 4,".\n"
                    + "\t\"Why are you doing that?\"  \t\n"
                    + "\t\"That’s how we show we’re confused on my planet.\"\n"
                    + "\t\"We mostly just scratch our heads.\" \t\n"
                    + "\t\"What do you do when you’re angry?\" \t\n"
                    + "\t\""),
            new TextSegment(1, 4,".\" \n"
                    + "\t\"And when you’re happy?\"\n"
                    + "\t\"Mostly we "),
            new TextSegment(1, 4,".\""),
            new TextSegment(1, 4," and "),
            new TextSegment(1, 4,"just shook their heads.\n"
                    + "\t\"Want to ride along while I check out some more freaky strange stuff?\"\n"
                    + "\t\"Sure!\""
                    + "Space Alien clicked heels, and a weird unearthly contraption quick-scooted over and hovered in the air beside their ankles. "),
            // page 5
            new TextSegment(1, 5,"\"What a great skateboard!\" \t \n"
                    + "\t\"Fantabulously SUPER skateboard!\" \t \n"
                    + "\t\"Space-board!\" \n"
                    + " \tAll three hopped on and flew away soaring high over a big "),
            new TextSegment(1, 5," and an even bigger "),
            new TextSegment(1, 5,", curly-cueing around some "),
            new TextSegment(1, 5," and nearly knocking over an in-the-way "),
            new TextSegment(1, 5,"  Space Alien snapped picture after picture, "),
            new TextSegment(1, 5," and "),
            new TextSegment(1, 5," and "),
            new TextSegment(1, 5," and "),
            new TextSegment(1, 5,".\n"
                    + "\t\"That’s enough.  Thanks for helping me do the best school project ever!\" \n"
                    + "\t\"Glad to help.  But you know—\"\t\t\t\t \n"
                    + "\t\"What?\" \n"
                    + "\t\"We’ve got our own school project due next week.\" \t\n"
                    + "\t\"About some place we’d like to visit.\" \t\t\n"
                    + "\t\"Do you think, maybe—\" \t\n"
                    + "\t\"Maybe—\"\t\t\t\n"
                    + "\t\"I’ll be back same time tomorrow night!  Bring your cameras!\"\n"
                    + "\tAnd they did!\t"),
    };

    private Blank[] blanks = {
            new Blank("A-2",false),
            new Blank("C-2",false),
            new Blank("AA", true),
            new Blank("BB", true),
            new Blank("CC", true),
            new Blank("DD", true),
            new Blank("FF", true),
            new Blank("GG", true),
            new Blank("HH", true),
            new Blank("JJ", true),
            new Blank("KK", true),
            new Blank("LL", true),
            new Blank("MM", true),
            new Blank("NN", true),
            new Blank("OO", true),
            new Blank("PP", true),
            new Blank("QQ", true),
            new Blank("RR", true),
            new Blank("SS", true),
            new Blank("TT", true),
            new Blank("UU", true),
            new Blank("VV", true),
            new Blank("XX", true),
            new Blank("YY", true),
            new Blank("ZZ", true)
};

    @Override
    public List<TextSegment> getTextSegmentsForStoryPage(int storyId, int pageNumber) {
        List<TextSegment> storyPageSegments = new ArrayList<>();

        for (TextSegment segment : textSegments) {
            if (segment.getStoryId() == storyId && segment.getPageNumber() == pageNumber) {
                storyPageSegments.add(segment);
            }
        }

        return storyPageSegments;
    }

    @Override
    public Story[] getStories() {
        return stories;
    }

    @Override
    public Story getStory(int storyId) {
        for (Story story : stories) {
            if (story.storyId == storyId) {
                return story;
            }
        }
        return null;
    }
}
