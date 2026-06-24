# Exercise 7: Financial Forecasting

## Note

This README was originally written by me. I used AI assistance only to improve the formatting and convert the content into a more readable Markdown document. The implementation, understanding, and explanation of the project are my own.

---

## Problem Statement

The given problem was:

> You are developing a financial forecasting tool that predicts future values based on past data.

### Steps

1. Understand Recursive Algorithms – explain the concept of recursion and how it simplifies certain problems.
2. Setup – create a method to calculate the future value using a recursive approach.
3. Implementation – implement a recursive algorithm to predict future values based on past growth rates.
4. Analysis – discuss the time complexity and explain how to optimize the recursive solution to avoid excessive computation.

---

## Project Setup

I created a Java project in Visual Studio Code and added a class named `FinancialForecaster` inside the package `Week1.FinancialForecasting`.

The class contains:
- `forecastConstant()` – for fixed growth rates.
- `forecastVariable()` – for varying historical growth rates.
- A `main()` method to test both implementations.

---

## Implementation

According to the requirements, I implemented two recursive forecasting methods.

### Constant Growth Rate

For a fixed growth rate (e.g., 5% per year), the recurrence relation is:

> `F(t) = F(t-1) × (1 + g)`

In code, this becomes:

```java
double nextValue = currentValue * (1 + growthRate);
return forecastConstant(nextValue, growthRate, periodsAhead - 1);
```

### Variable Growth Rates

I also implemented a version that accepts an array of historical growth rates. This allows the forecast to use rates observed from past data (e.g., 4%, 6%, 5%) rather than assuming a single fixed rate.

The recursive helper walks through the array index by index until all rates have been applied.

---

## Understanding the Recurrence Formula 

Initially, the recurrence formula in the exercise document felt quite ambiguous. I wasn't sure exactly how to translate `F(t) = F(t-1) * (1 + g)` into code.

The critical insight came when I understood what `1 + g` actually represents:
- The `1` preserves **100% of the current base value** – it ensures you don't lose your starting amount.
- The `g` adds the **growth percentage** on top.

Without the `1`, multiplying by just `g` would give only the growth amount (e.g., 100,000 × 0.05 = 5,000), which is not the total forecast. You would then have to add the base back separately. Factoring it into `(1 + g)` combines both steps into a single, clean multiplication.

---

## Analysis – Complexity and Optimization

### Time Complexity

Both recursive methods make exactly `n` recursive calls, where:
- `n` = `periodsAhead` (for constant growth)
- `n` = `historicalRates.length` (for variable growth)

Each call performs a single multiplication and addition.  
**Overall Time Complexity: O(n).**

### Space Complexity - The Hidden Problem

Every recursive call occupies a frame on the call stack. This means my implementation uses **O(n) auxiliary space**.

For small forecasts (3–5 years), this is perfectly fine. But if I tried to forecast 10,000 months ahead, the program would crash with a `StackOverflowError`. This was a real "struggle" moment – recursion looks elegant on paper, but it has real physical limits.

### What I Did Later (Optimizations I Considered)

Even though the exercise only required a basic recursive implementation, I explored how to fix the space issue:

1. **Convert to Iteration** – Since both methods are tail-recursive, I could easily rewrite them as `for` or `while` loops. This reduces space complexity to **O(1)** without changing the logic.

2. **Closed-Form Formula** – For constant growth, the recurrence simplifies to:
   > `F(n) = F(0) × (1 + g)^n`
   Using `Math.pow()` would give the result in **O(1)** time and space – the ultimate optimization.

3. **Exponentiation by Squaring** – If I absolutely had to stay recursive, I could implement a divide-and-conquer recursion that reduces the stack depth from O(n) to **O(log n)**. This safely handles millions of periods without crashing.

---

## Why the Current Implementation Was Kept

For this specific exercise, the goal was to demonstrate understanding of **recursive algorithms** and the **recurrence formula** used in financial forecasting.

The basic recursive implementation:
- Clearly shows the base case and recursive step.
- Directly mirrors the mathematical definition.
- Works perfectly for the test cases provided (3 periods).

Therefore, I intentionally kept the implementation simple and focused on getting the recursion right. The optimization discussion is included in the analysis step to show that I understand the limitations and know how to address them in a production environment.

---

## Output

*(The slight floating-point precision difference in the first output is expected when using `double` arithmetic in Java.)*