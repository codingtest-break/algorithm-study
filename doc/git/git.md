---
title: Git 기초 및 활용법
category: post
tags: git git-flow study
---

# Git 기초 및 활용법

- [Git 기초 및 활용법](#git-기초-및-활용법)
  - [Git](#git)
  - [버전 관리(형상 관리)](#버전-관리형상-관리)
  - [다시 Git으로](#다시-git으로)
  - [Git, Github의 관계](#git-github의-관계)
  - [Git 사용 환경](#git-사용-환경)
  - [Git 기본 용어 설명](#git-기본-용어-설명)
  - [자주 쓰는 Git 명령어 설명](#자주-쓰는-git-명령어-설명)
    - [`git init`](#git-init)
    - [`git clone`](#git-clone)
    - [`git add`](#git-add)
    - [`git push`](#git-push)
    - [`git pull`](#git-pull)
    - [`git reset`](#git-reset)
    - [`git revert`](#git-revert)
    - [`git stash`](#git-stash)
    - [`git pop`](#git-pop)
    - [`git branch`](#git-branch)
    - [`git checkout`](#git-checkout)
    - [`git merge`](#git-merge)
    - [`git rebase`](#git-rebase)
    - [`git cherry-pick`](#git-cherry-pick)
  - [Pull Request(PR)](#pull-requestpr)
  - [참고자료](#참고자료)


## Git
Git은 분산 버전 관리 시스템이다.
버전 관리라는 것을 분산해서 하는 시스템이라는 것인데, 무슨 말인지 이해가 잘 되지 않는다.
이 정의를 이해하려면 먼저 버전 관리라는 용어의 의미를 이해해야 한다.
## 버전 관리(형상 관리)
우리가 코드를 작성하고 수정하고 배포를 하면서, 우리가 작성하는 애플리케이션은 계속 변화한다.
그리고 이러한 변화를 버전(Version)이라는 형태로 관리를 한다.
보통 숫자를 매기거나, 알파벳을 추가하기도 하며 작성한 코드의 변화를 기록한다.

즉, **버전 관리**(또는 **형상 관리** 라고도 한다.)라는 용어는 코드가 언제, 누구에 의해, 그리고 어떤 변화가 있었는지를 데이터로 저장하는 역할을 한다.

뿐만 아니라, 버전 관리에는 단순히 코드의 변화를 저장하는 역할 뿐만 아니라, 현재까지 작성된 코드가 문제가 있을 시에 다시 이전 버전으로 돌아갈 수도 있다(이를 롤백, Rollback 이라고 한다.)

이렇게 버전을 관리할 때 우리는 많은 이점을 얻게 된다.
(버전 관리를 사용하지 않을 때와 비교하였을 때의 이점)
1. 직접 변경 사항을 파일의 형태로 저장하고 보관하는 번거로움이 줄어든다.
2. 롤백이 빠르게 가능하기 때문에 배포한 코드에서 오류가 있을 경우 신속하게 대처가 가능하다.
3. 현재의 상태 또한 저장되어 있기 때문에, 테스트 버전이나 유사한 환경을 만드는 것도 용이하다.

## 다시 Git으로
그렇다면 이제 버전관리는 이해를 하였으니, 분산이라는 용어의 의미를 알 필요가 있다.
왜 버전 관리 시스템이라고 하지 않고 **분산** 이라는 용어를 붙인 것일까? 
굳이 분산이라는 용어를 붙였다는 것은 분산형이 아닌 버전 관리 시스템도 있는 것인가라는 의문이 들 수 있다.

그렇다. 버전 관리 시스템도 여러 종류가 있다.
그리고 Git과 가장 대비되는 버전 관리 시스템은 **SVN**이 있다.
SVN은 Git과 다르게 중앙 저장소(Repository 라고 함)를 중심으로 코드를 관리한다.
반면에 Git은 저장소를 관리하는 개발자들 각각의 컴퓨터에 **분산되어** 저장한다는 차이점이 있다. 
## Git, Github의 관계
그럼 이제 Git과 Github 이 두가지의 차이를 알아보자.

이 개념을 설명하기 위해서는 Local Repository, 그리고 Remote Repository를 알아야 한다.

앞서 보았듯이, Git은 분산 버전 관리 시스템이기 때문에, 한 레포지토리의 코드가 여러 컴퓨터에 분산되어 저장된다.

예시를 들자면, 개발자 A,B,C가 blog 라는 레포지토리를 관리한다면, blog라는 레포지토리는 A,B,C의 컴퓨터에 각각 저장되어 있을 것이다.

그리고 이때, A와 B와 C가 작성하는 코드가 겹치지 않아서 서로 다른 버전을 가지게 되는 상황이라고 가정을 해보자. 
결국 우리는 A와 B와 C가 개발한 기능들이 모두 반영이 되어야 한다.
이 때 어떤 개발자의 저장소가 중심가 되어야 할까?

![Remote가 없을 때](../asset/image/git/no-remote.001.jpeg)

예를 들어 B의 저장소가 중심이 되고(항상 최신 기능들을 가지고 있고) 나머지가 B의 저장소를 기준으로 삼는다고 해도 이는 좋은 방법이 아니다.

왜냐하면 B도 자신의 맡은 부분을 개발해야 하고, B의 저장소 코드 역시 수시로 변할 것이기 때문에, A와 C는 계속 B의 코드를 동기화 해야 하며, B가 개발하는 상황에 A와 C의 코드가 영향을 받는다.
그리고 만약 B의 코드에 버그나 에러가 있을 경우, A와 C의 코드도 같이 문제가 생기는 현상이 생기는 것이다.

그럼 이 문제를 어떻게 해결할까?
해결 하는 방법은 다음과 같다.

**A도 B도 C도 아닌 다른 곳에 기준점이 있으면 된다.**

다른 어떤 곳, 프로젝트 팀원들이 접근이 용이한 인터넷 상에 저장소가 있다면, 관리가 쉬워진다.
모든 개발자는 인터넷 상의 저장소를 바라보면 되고, 다른 사람들의 코드 변경을 신경쓰지 않아도 된다.

![Remote가 필요한 때](../asset/image/git/only-local.001.jpeg)

Git은 이 문제를 해결하기 위해 Local 저장소(각자의 컴퓨터에 저장된 저장소)와 Remote 레포지토리(인터넷 상에 올라가 있는 저장소)를 두었다.

프로젝트에서 개발을 담당하는 모든 개발자는 Remote를 기점으로 자신의 코드를 작성하면 되며, 내 코드를 Remote에 반영하면 되는 것이다.
그래서 실제 Git을 사용할 때는 Remote에 올라와있는 버전을 내 컴퓨터로 가져와서 작업을 하고, 이를 인터넷 상에 변경사항을 업로드 하는 식으로 진행 된다.

> 사실 Upstream 을 사용하는 방법도 있으나 이는 뒤에서 설명하겠다.
> 
> Remote를 사용하는지, Upstream을 사용하는지는 속한 조직의 룰에 따라 다르다.
> Upstream을 사용하는 경우는 주로 오픈소스에 내 변경사항을 건의하여 반영하고 싶을 때 사용하는 방식이다.

![Local 과 Remote](../asset/image/git/remote.001.jpeg)

저장소를 인터넷 상에 저장하기 위해서는 인터넷에서 저장소를 만들 수 있도록 제공이 되어야 한다.
그리고 이 저장소를 제공하는 대표적인 사이트가 바로 `Github` 이다.
리모트 레포지토리를 생성할 수 있는 곳은 `Github` 뿐만 아니라 여러 곳이 있으며, 대표적인 사이트 들은 아래의 사이트들이 있다.
- Gitlab
- BitBucket

## Git 사용 환경
모든 개발환경이 그렇듯이, Git도 두 가지 사용 환경을 제공한다.
1. CLI(Command Line Interface)
2. GUI(Graphic User Interface)

CLI의 경우 흔히 터미널이라 불리는 검은 창에 
```bash
git add .
git commit -m "Init Commit"
git push
```
등의 형태로 사용하는 방식이다.
CLI 환경은 리눅스 기반이라면 OS 설치시에 이미 내장 되어 있으며, 윈도우의 경우 git을 설치하면 git bash에서 사용 가능하다.

반면에 GUI는 우리가 일반적으로 사용하는 인터페이스이다.
GUI로 git을 제공하는 많은 프로그램들이 있는데, 일부를 소개하겠다.

- GitKraken
- Github Desktop
- Sourcetree
- 등등

여기서는 GitKraken을 기준으로 Git 명령 사용법을 이해해본다.

GitKraken을 사용하는 이유는 GUI 환경에서 Git을 가장 잘 활용할 수 있도록 도와주기 때문이며,
다음 문서에서 다룰 git-flow나 사용하기 어려운 git 명령어도 직관적으로 이해하기 쉬운 인터페이스를 제공한다.
CLI 환경에서 사용하는 방법은 추후에 문서를 업데이트 하거나, 참고 링크를 추가하도록 하겠다.

## Git 기본 용어 설명

## 자주 쓰는 Git 명령어 설명

### `git init`

### `git clone`

### `git add`

### `git push`

### `git pull`

### `git reset`

### `git revert`

### `git stash`

### `git pop`

### `git branch`

### `git checkout`

### `git merge`

### `git rebase`

### `git cherry-pick`

## Pull Request(PR)

## 참고자료
- [Git 간편 안내서](https://rogerdudler.github.io/git-guide/index.ko.html)
- [nomadcoder 강의](https://nomadcoders.co/git-for-beginners)
- [생활코딩 Git 강의](https://opentutorials.org/module/3733)
- [Git vs SVN](https://velog.io/@lzhxxn/Git-이란)
