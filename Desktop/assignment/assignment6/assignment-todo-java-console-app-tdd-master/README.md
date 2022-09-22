# Assignment todo Java Console Application TDD

## 简介

本次 assignment 的目标是以 TDD 的方式再次实现 GTB  Todo Java Console Application。

确切的说，是以“地道”的 TDD 的方式。

## 需求说明

### 功能需求

本次的重点在 TDD，我们不用完成所有功能，只需要保证覆盖以下功能即可：

* init
* list
* add
* mark

需求的细节跟 Step01 的 `assignment-todo-cli` 是完全一样的，请自行参考。

### 技术实现要求

后文中的数据文件指 `$HOME/.todo/tasks` 。

* 数据文件中每一行对应一个 task
* 每一行都包含对应 task 的 ID
* 具体字段顺序，如 ID 字段，是放到开始还是中间某个位置，可以自行设计
* 如果要实现 delete 功能，请实现为硬删除，即删除之后数据文件中不再有该 task 对应的数据了
  * 注：delete 功能不在必须实现功能的范围内

### 工程要求

* 根据本 step 所学内容，使用 `gradle init` 从零开始生成一个项目，操作过程需记录在录屏中

### TDD 实践要求

* 必须先做 tasking，并包含在录屏中，过程中的计划变动也要及时更新 tasking 内容
* 严格遵守 TDD Cycle：Red -> Green -> Refactoring
* 严格遵守 The 3 Laws of TDD
* 确保使用到了 Stub
* 确保使用到了 Mock
* 小步提交

现在是学习阶段，我们是在“ [刻意练习](https://yuedu.163.com/source/592103d858494fd5bc903467f990141a_4) ”。不管要实现的需求或任务有多么简单，请按照“不择手段快速实现”和“重构”这样的节奏来进行你的 TDD 过程。

不可以在通过测试阶段直接就把 TaskMarshaller、TaskRepository、CommandFactory 等等组件直接写出来，它们需要在重构的阶段，根据 Code Smell 有理有据的 refactor 出来。

再次重申：现实项目中不一定非要这么做，但我们现在是刻意练习，必须这么做。

## 提交要求

* 请在建议的完成时间内提交，提交时请确保录屏也已完成；
* 通过金数据表单提交 assignment，提交成功后会收到系统通知；
* 批改 assignment 会使用提交时间点所对应的版本，请务必在确认无误后再进行提交；
* 获取录屏的具体方式请写在 RECORDING.md 文件中，确保 buddy/coach 能够访问；
* 本次 assignment 录屏时长需在 **80** 分钟以内；

## 评分标准

Buddy 会根据以下指导规则对大家本次的 assignment 进行评级。

**特别提醒：**

大家刚刚开始接触 Tasking、Refactoring、TDD，本次的 assignment 只是为了帮助大家了解自己的学习情况，不是为了考试评级，请大家不要有过多的心理负担。

给出一个明确的评级指导规则，是为了一方面让 buddy 们尽量能够统一标准。另一方面，也让大家能够明确目标。

对于初学者而言，能在学完当前 Step 后：

* 做到 Level-1 👉🏻 不错喽
* 做到 Level-2 👉🏻 很好
* 做到 Level-3 👉🏻 Fantastic!

另外，大家在本次录屏中可以适当减少解说的时间，只需说明当前要开始或者正在进行的步骤即可，不用像 coach 在 demo 中那样“啰嗦”:P

对于简单的解说，你可能经常用到的语句是下面这些：

* 好的，我现在要开始第 N 个 task，……
* 现在开始写测试
* 现在要写一个 集成/单元 测试
* 好的，测试写完了，现在来快速的实现它
* 吼吼，测试通过了，看看是否需要重构
* 这里有明显的坏味道，我现在要开始重构
* 现在来提交一次
* 等等……

### Level-0

1. 无法满足 Level-1 的所有要求时，则为 Level-0。

### Level-1

1. 在录屏的开始展示并简单介绍 tasking 结果
2. 运行 `gradle init` 来初始化项目并在录屏中记录整个过程
3. 至少完成 list、add 功能
4. 符合`技术实现要求`一节所列要求
5. 有测试，但不一定严格遵循 TDD Cycle 或 3 Laws
6. 小步提交

强调：一直先写实现，然后再去补测试，是绝对不满足 Level-1 的要求的。

### Level-2

1. 完成所有要求的功能：init、list、add、mark
2. 有测试，且能基本做到遵循 TDD Cycle 或 3 Laws，即基本上总是测试先行（Test First）
3. TDD 过程中明确的体现出重构过程，但可以不够频繁或充分

### Level-3

1. 明确的体现出了频繁的 “快速实现” 和 “重构” 两个阶段的交替过程
2. 正确使用到了 Test Double 里的：Stub 和 Mock
