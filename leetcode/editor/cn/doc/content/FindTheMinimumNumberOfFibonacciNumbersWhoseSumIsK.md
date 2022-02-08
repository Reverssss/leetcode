<p>给你数字 <code>k</code>&nbsp;，请你返回和为&nbsp;<code>k</code>&nbsp;的斐波那契数字的最少数目，其中，每个斐波那契数字都可以被使用多次。</p>

<p>斐波那契数字定义为：</p>

<ul>
	<li>F<sub>1</sub> = 1</li>
	<li>F<sub>2</sub> = 1</li>
	<li>F<sub>n</sub> = F<sub>n-1</sub> + F<sub>n-2</sub>&nbsp;， 其中 n &gt; 2 。</li>
</ul>

<p>数据保证对于给定的 <code>k</code>&nbsp;，一定能找到可行解。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>k = 7
<strong>输出：</strong>2 
<strong>解释：</strong>斐波那契数字为：1，1，2，3，5，8，13，&hellip;&hellip;
对于 k = 7 ，我们可以得到 2 + 5 = 7 。</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>k = 10
<strong>输出：</strong>2 
<strong>解释：</strong>对于 k = 10 ，我们可以得到 2 + 8 = 10 。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>k = 19
<strong>输出：</strong>3 
<strong>解释：</strong>对于 k = 19 ，我们可以得到 1 + 5 + 13 = 19 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= k &lt;= 10^9</code></li>
</ul>
<div><div>Related Topics</div><div><li>贪心</li></div></div><br><div><li>👍 100</li><li>👎 0</li></div>