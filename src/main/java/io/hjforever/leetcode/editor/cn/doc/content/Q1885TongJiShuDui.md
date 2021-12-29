<p>给你两个长度为 <code>n</code> 的整数数组 <code>nums1</code>&nbsp;和&nbsp;<code>nums2</code> ，找出所有满足 <code>i &lt; j</code> 且 <code>nums1[i] + nums1[j] &gt; nums2[i] + nums2[j]</code>&nbsp;的数对 <code>(i, j)</code> 。</p>

<p>返回满足条件数对的<strong> 个数</strong> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums1 = [2,1,2,1], nums2 = [1,2,1,2]
<strong>输出：</strong>1
<strong>解释：</strong>满足条件的数对有 1 个：(0, 2) ，因为 nums1[0] + nums1[2] = 2 + 2 &gt; nums2[0] + nums2[2] = 1 + 1</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums1 = [1,10,6,2], nums2 = [1,4,1,5]
<strong>输出：</strong>5
<strong>解释：</strong>以下数对满足条件：
- (0, 1) 因为 nums1[0] + nums1[1] = 1 + 10 &gt; nums2[0] + nums2[1] = 1 + 4
- (0, 2) 因为 nums1[0] + nums1[2] = 1 + 6 &gt; nums2[0] + nums2[2] = 1 + 1
- (1, 2) 因为 nums1[1] + nums1[2] = 10 + 6 &gt; nums2[1] + nums2[2] = 4 + 1
- (1, 3) 因为 nums1[1] + nums1[3] = 10 + 2 &gt; nums2[1] + nums2[3] = 4 + 5
- (2, 3) 因为 nums1[2] + nums1[3] = 6 + 2 &gt; nums2[2] + nums2[3] = 1 + 5
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == nums1.length == nums2.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums1[i], nums2[i] &lt;= 10<sup>5</sup></code></li>
</ul>
<div><div>Related Topics</div><div><li>数组</li><li>二分查找</li><li>排序</li></div></div><br><div><li>👍 5</li><li>👎 0</li></div>