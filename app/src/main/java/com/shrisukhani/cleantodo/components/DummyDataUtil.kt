package com.shrisukhani.cleantodo.components

private val LOREM_IMPSUM = ("Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
        "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Orci eu lobortis " +
        "elementum nibh tellus molestie nunc non blandit. Commodo nulla facilisi nullam " +
        "vehicula ipsum. Elementum nibh tellus molestie nunc non. Velit euismod in pellentesque" +
        " massa. Sapien pellentesque habitant morbi tristique. Non nisi est sit amet facilisis" +
        " magna etiam tempor. Leo duis ut diam quam nulla porttitor massa. Nisi vitae suscipit " +
        "tellus mauris a diam maecenas sed enim. Eleifend mi in nulla posuere. Lacinia quis vel" +
        " eros donec. Cursus metus aliquam eleifend mi in nulla. Tempus urna et pharetra pharetra" +
        " massa massa ultricies. Semper feugiat nibh sed pulvinar proin gravida. Risus sed " +
        "vulputate odio ut enim blandit volutpat maecenas volutpat.").split(" ")

fun getLoremIpsumText(numberOfWords: Int = 4) = (
        if (numberOfWords > LOREM_IMPSUM.size)
            LOREM_IMPSUM
        else LOREM_IMPSUM.subList(0, numberOfWords)
    ).joinToString(" ")