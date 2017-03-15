Redux
---

## Basics
###  Store
- 保存应用状态;
- ` getState()` 获取状态;
- `dispatch(action)` 更新状态;
- `subscribe(listener)` 添加监听者;
- `subscribe(listener)` 取消监听.

###  Action & ActionCreator
**Actions** 负责将应用数据传递给 Store。
包含一个 `type` 字段和操作所需的信息，传递的信息应该尽可能的小。
比如传递一个 index 好于传递整个 item 信息。
```
{
  type: TOGGLE_TODO,
  index: 5
}
```
**ActionCreator** 创建 Action 的场所。

###  Reducers

消费 Action 的位置.   **传入同一参数返回值永远不变。无副作用，没有API调用，不会修改参数，纯计算。**

永远不要在 reducer 里执行以下操作：
- 修改参数;
- 调用有副作用的 API，跳转操作;
- 调用非纯函数, e.g. `Date.now()` or `Math.random()`.

#### Splitting Reducers

### Data Flow
Redux 框架遵循严谨的单向数据流.
- 调用 store.dispatch(action) 分发 Action
- Redux store 调用内部的 reducer 函数.
- Root reducer 可以是将许多 reducer 的返回值组合成新的状态树.
- Redux store 保存 root reducer 返回的状态树。

### Middleware
Middleware 提供了 `dispatch(action)` 和 `reducer` 这两个操作之间的扩展点。并且可以组合成一个链式调用。在 Redux 中可以使用 middleware 完成打 log，异常反馈，异步操作，路由等操作。

### Async Actions
网络请求为例：
产生网络请求 Action，这个 Action 包括**网络请求具体所需要的信息**和**请求完成后下一步操作的  `nextAction`**。由专门执行异步操作的 Middleware 去执行耗时操作，待结果返回后调用 `store.dispatch(nextAction)`。


## Three Principles
- 唯一数据源
- State 是只读的
- 状态的修改是纯函数完成的。
