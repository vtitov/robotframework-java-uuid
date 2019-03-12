*** Settings ***
Documentation   uuid keywords.
Library         String
Library         JavaUUID
#Resource        ../Lib.robot


*** Test Cases ***

Random UUID
    ${u}                Random UUID
    ${v}                Convert To String   ${u}
    Should Match UUID   ${v}

Fixed UUID
    ${v}                Create UUID     ${7544302429964684081}   ${-5380732791977519936}
    Should Match UUID   ${v}

#Fixed UUID String16
#    ${v}                Create UUID     e3905e79d8fb4a11   a33369988e1b1d6a     16
#    Should Match UUID   ${v}

Fixed UUID String10
    ${v}                Create UUID     7544302429964684081   -5380732791977519936
    Should Match UUID   ${v}

String UUID
    ${v}                From String     e3905e79-d8fb-4a11-a333-69988e1b1d6a
    Should Match UUID   ${v}


*** Keywords ***
Should Match UUID
    [Arguments]  ${uid}
    ${str}                Convert To String   ${uid}
    Should Not Be Empty             ${str}
    Length Should Be                ${str}  ${36}
    Should Match Regexp             ${str}    [0-9A-Fa-f]{8}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{12}
