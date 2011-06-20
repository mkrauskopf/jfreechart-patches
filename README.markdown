jfreechart-patches project contains [bunch of patches](#patch_list) against [JFreeChart][] project.

  [JFreeChart]: http://www.jfree.org/jfreechart/ "JFreeChart"

The reason for founding this project is recent inactivity in JFreeChart project. Maintaining patches
in JFreeChart issue tracker (in combination with local repository) is cumbersome when number of
patches grows.


List of patches
---------------
* Radar chart (spider web plot) enhancements:
    * setting origin and maximum for each axis independently
    * support for negative values
    * head outline stroke customization
    * partial support for tick marks with labels for axes
    * drawing data points with values which are out of axis range. Such data points are drawn as cross-hair at
      axis range boundary (origin or maximum).
    * reversing axis direction (so far for explicit range only)

    Screenshot of radar chart with new features:

    ![Radar Chart](https://github.com/mkrauskopf/jfreechart-patches/raw/jfreechart-1.0.x/docs/images/radar-chart.png)
* JDK 1.4 compatibility
* update of NetBeans project metadata

