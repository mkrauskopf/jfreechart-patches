Description
===========
jfreechart-patches project contains [bunch of patches](#patch_list) against [JFreeChart][] project.

  [JFreeChart]: http://www.jfree.org/jfreechart/ "JFreeChart"

**Update**: seemingly the below note about inactivity is not true anymore. The JFreeChart project was [revived]
again so hopefully this repository will be cancelled in the near future.

  [revived]: https://sourceforge.net/mailarchive/forum.php?thread_name=4E9366C6.6010209%40object-refinery.com&forum_name=jfreechart-developers

The reason for founding this project is recent inactivity in JFreeChart project. Maintaining patches
in JFreeChart issue tracker (in combination with local repository) is cumbersome when number of
patches grows.

Since the patches are mainly against spider web plot so far (that is just a few classes) I've decided to not
forking whole JFreeChart repository (which has ~40MB) but only changed classes. This might possibly turn out as
a unwise decision in which case I'll switch to complete fork.


List of patches
===============
* Radar chart (spider web plot) enhancements:
    * setting origin and maximum for each axis independently
    * support for negative values
    * head outline stroke customization
    * partial support for tick marks with labels for axes
    * drawing data points with values which are out of axis range. Such data points are drawn as cross-hair at
      axis range boundary (origin or maximum).
    * reversing axis direction (so far for explicit range only)
    * auto-adjusting font-size for axis labels (see "Valence Electrons" and "Electric Conductivity" in the
      screenshot below for an example)

    Screenshot of radar chart with new features:

    ![Radar Chart](https://github.com/mkrauskopf/jfreechart-patches/raw/jfreechart-1.0.x/docs/images/radar-chart.png)
* JDK 1.4 compatibility
* update of NetBeans project metadata
* fix wrongly painted (left-shifted) minimum and maximum lines in box plot
* fix Ant _test_ target and make tests compilable

