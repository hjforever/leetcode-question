<p>A <strong>stepping number</strong> is an integer such that all of its adjacent digits have an absolute difference of exactly <code>1</code>.</p>

<ul>
	<li>For example, <code>321</code> is a <strong>stepping number</strong> while <code>421</code> is not.</li>
</ul>

<p>Given two integers <code>low</code> and <code>high</code>, return <em>a sorted list of all the <strong>stepping numbers</strong> in the inclusive range</em> <code>[low, high]</code>.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre>
<strong>Input:</strong> low = 0, high = 21
<strong>Output:</strong> [0,1,2,3,4,5,6,7,8,9,10,12,21]
</pre>

<p><strong>Example 2:</strong></p>

<pre>
<strong>Input:</strong> low = 10, high = 15
<strong>Output:</strong> [10,12]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= low &lt;= high &lt;= 2 * 10<sup>9</sup></code></li>
</ul>
<div><div>Related Topics</div><div><li>广度优先搜索</li><li>回溯</li></div></div><br><div><li>👍 33</li><li>👎 0</li></div>