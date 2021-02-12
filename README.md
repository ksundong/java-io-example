# IO Example Project

## 개발 환경

- java11(amazon corretto)
- gradle 6.7
- IntelliJ IDEA

## 발생했던 문제

### gradle 프로젝트에서 File I/O를 할 때, resources 접근방법은?

뭔가 gradle을 잘못 알고있다는 느낌을 받았습니다.  
제가 생각하기엔 `input.txt`, `output.txt`를 상대경로로 접근할 수 있어야하는데, 그게 되지 않아서 classpath 문제를 의심하게 되었습니다.

스프링에서는 제가 알기로 ClasspathResource에 접근하는 방법이 있었는데, 그냥 자바에서는 어떻게 할지 좀 더 생각해봐야겠습니다.

### gradle 프로젝트 빌드하고 실행하기

`./gradlew build` 를 한 다음 `java -jar` 명령으로 실행했더니

```text
no main manifest attribute, in build/libs/ioexample-1.0.0.jar
```

이런 오류가 발생했습니다. 해당 오류를 트러블 슈팅 해본 결과
이 [링크](https://stackoverflow.com/questions/9689793/cant-execute-jar-file-no-main-manifest-attribute)에서
해결방법을 알게되었습니다.

```groovy
jar {
    manifest {
        attributes(
                'Main-Class': 'dev.idion.ioexample.CopyBytes'
        )
    }
}
```

를 `build.gradle`에 추가시켜주면 됩니다.

## 추가로 공부가 된 내용

zsh 단축키에 대해서 좀 더 생각해보게 되었습니다.

<https://cheatography.com/davidsouther/cheat-sheets/bash-zsh-shourtcuts/>

[Mac에서 Option키 누르면 이상한 문자써지는거 막는방법](https://discussions.apple.com/thread/6469785#:~:text=System%20Preferences%20%3E%20Keyboard%20%3E%20Modifier%20Keys,%3E%20Option%20Key%20%3E%20No%20Actions.)

- `ctrl + u`: 입력프롬프트 비우고 해당 내용 버퍼에 저장하기
- `ctrl + y`: 버퍼에 저장되어있는 내용 붙여넣기
- `ctrl + k`: 커서 오른쪽의 문자열 비우고 해당 내용 버퍼에 저장하기
- `ctrl + a`: 커서를 맨 앞으로 이동(Home)
- `ctrl + e`: 커서를 맨 뒤로 이동(End)
- `ctrl + b`: 커서를 앞으로 이동(왼쪽 방향키, backwards)
- `opt + b`: 커서를 한 단어 앞으로 이동(backwards)
- `opt + f`: 커서를 한 단어 뒤로 이동(forwards)
- `ctrl + f`: 커서를 뒤로 이동(오른쪽 방향키, forwards)
- `ctrl + h`: 한 글자씩 지우기
- `ctrl + w`: 한 단어씩 지우기
- `ctrl + t`: 이전 문자 위치로 이동
- `opt + t`: 이전 단어 위치로 이동
- `ctrl + p`: 이전 line 불러오기(위쪽 방향키)
- `ctrl + n`: 이후 line 불러오기(아래쪽 방향키)
- `ctrl + r`: 이전 명령 검색 zsh + fzf에서는 fzf로 탐색

---

- `ctrl + c`: 현재 프로세스 종료
- `ctrl + d`: 셸 나가기

---

- `ctrl + z`: 프로세스 일시 중지
- `fg`: 프로세스 재시작
- `bg`: 프로세스 백그라운드에서 재시작

