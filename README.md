To reproduce the issue, run `paging cachedIn collect` unit test.

You should see something similar to:

```
expected:<1> but was:<0>
Expected :1
Actual   :0
<Click to see difference>

java.lang.AssertionError: expected:<1> but was:<0>
...
```

Next, uncomment the `coroutineTestRule` above this unit test and re-run.  It will pass without any issues now.


How do we have the test pass successfully without this rule? Is it possible?
