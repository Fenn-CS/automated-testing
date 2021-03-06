# Automated Testing for VMS

The QA process is divided as follows:

- Continuous Integration: Used travis to setup CI for VMS Project
- Functional Testing: Used Selenium to write UI tests from an end-users perspective.(black-box tests)
- Unit Testing: Unit-tests have been written for services in the codebase.(white-box tests)

## Few important points regarding CI

- `.travis.yml` is the config file to run the travis build
- Build can be viewed at `https://travis-ci.org/systers/vms`
- Status would be reflected in the badge in `README.md`

## Few important points regarding Functional Testing

- Selenium, a browser automation tool is used to simulate the functionality. Python APIs for selenium are used in the tests.
- Django provides a class `LiveServerTestCase`. What this does is that, it setups a Virtual Django Sever in the background which can be used by selenium to run tests.
- So, each testcase Class inherits `LiveServerTestCase`, Contains a `setUp` and `tearDown` method to instantiate and end live-server respectively. Each testcase in the class begins with `test`.
- Each Test Class covers a view. Class name represents the name of the view in nav-bar. Test suite for a view is contained in `tests` folder of the app containing the view. For Ex: `Volunteer Search` tab in the nav-bar of an admin user redirects to `http://127.0.0.1:8000/volunteer/search/`, so the corresponding tests for this view would be in `VolunteerSearch` class in `tests` folder of `volunteer` app.
- Each app contains a `tests` folder containing the unit-tests and functional tests and an `__init__.py` to let django consider it as a package.

## Few important points regarding design pattern for Selenium tests:

- The tests follow the page object model design. Pages in vms have been broken into objects which model their behaviour. The `pom` folder contains the architecture setup for this design.
- Each test file interacts with respective page objects and reuses their methods. To locate elements on the page both pages and tests use static locators defined in `pom/locators` folder. `pom/pages` folder contains the pages mapping to vms.
- To follow up changes in UI with changes in tests, the modifications need to be made only in the relevant `locators/urls/page` file.
