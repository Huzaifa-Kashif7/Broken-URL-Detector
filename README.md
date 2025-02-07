# Broken-URL-Detector
𝐀𝐜𝐭𝐢𝐨𝐧 𝐏𝐫𝐢𝐧𝐜𝐢𝐩𝐥𝐞:

- This project follows Page Object Model (POM) design pattern which creates an object repository for storing web elements, thereby increasing test-case management, and reducing code duplication.
- Firstly, the tool detects the number of url links available in the website.
- Secondly, it analyses each url link via parallel-mode execution, and checks whether the link is empty, possibly broken, or malfunctioning in any form, via the generated response code and the response message of each url link.
- Thirdly, after analyzing every link, it evaluates the total time spent in parallel-mode execution for the whole process.
- Lastly, test reports are generated via RunnerFile.xml, showcasing total number of test cases executed, their outcome, and any issues encountered (if any).

𝐓𝐞𝐜𝐡𝐧𝐨𝐥𝐨𝐠𝐢𝐞𝐬 𝐔𝐭𝐢𝐥𝐢𝐳𝐞𝐝:

- Java Programming Language
- Intellij Idea IDE
- Selenium Webdriver and TestNG
