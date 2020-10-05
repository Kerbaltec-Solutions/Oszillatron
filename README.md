# Oszillatron
<h2>What is the Oszillatron?</h2>
<p>The <i>Oszillatron</i> is a program for on-the-spot music creation, designed to help newcomers get into music and improvisation.</p>
<h2>Features:</h2>
<ul>
  <li>Theremin-ish music creation</li>
  <ul><li>control pitch and amplitude of a tone by moving your mouse over the "keyboard"</li></ul>
  <li>Nice sound through combination of multiple oszillators</li>
  <li>Vibrato mode</li>
  <ul>
    <li>start/stop <i>vibrato-mode</i> by pressing <b>v</b>.</li>
    <li>this adds a second set of oszillators slightly offset to the main note</li>
    <ul><li>you can change this offset with <b>s</b> and <b>f</b></li></ul>
  </ul>
  <li>up to four variable base tones</li>
  <ul>
    <li>use <b>1</b>, <b>2</b>, <b>3</b> and <b>4</b> to start/stop four base-tone-generators</li>
    <li>this doubles the note wich is played at the point of activation and keeps it until deactivation</li>
  </ul>
  <li>recording/playback</li>
  <ul>
    <li>use <b>r</b> to start/stop recording the drums and the main tone</li>
    <ul><li>recording overwrites the previously recorded track</li></ul>
    <li>use <b>p</b> to start/stop playing the recorded track</li>
    <li><i>rec/play</i> does not jet support <i>vibrato-mode</i> but this will follow soon</li>
  </ul>
  <li>drums</li>
  <ul>
    <li>bass-drum</li>
    <ul>
      <li>use <b>d</b> to play a (cheap) drum sound</li>
      <li>this is a really low tone so it may not be properly displayed by some loudspeekers -> use headphones</li>
    </ul>
    <li>cymbal</li>
    <ul>
      <li>use <b>c</b> to play a (cheap) cymbal sound</li>
      <li>it does not sound good, if anyone has a idea on how to better make a cymbal with oszillators i'm open for suggestions</li>
    </ul>
    <li>fariable frequencies</li>
    <ul><li>this is explained in the next chapter</li></ul>
    <li>marking points</li>
    <ul><li>use <b>m</b> to mark positions on the keypoard for the duration of the sitting</li></ul>
  </ul>
</ul>
<h2>To do before starting</h2>
<p>The <i>oszillatron</i> comes with variable frequency-ranges and note-markings. Those are determined by a sort of config-file named "frequencies.txt" this is composed in the following way:</p>
<ul>
  <li>first line: minimum-frequency "space" maximum-frequency</li>
  <li>following lines: marked-frequency "space" white-value-of-the-marking</li>
  <li>last line: 0 "space" -1</li>
</ul>
<p>There are several examples provided. They'r purpose is described by the name of the folder in wich theyr'e stored. It is advised to first use one of those to get a sense for the limitations and purposes of the <i>oszillatron</i>. To use the <i>oszillatron</i> you need to place a "frequencies.txt" file in the folder of the program (some-folder/oszillatron32-or-64). If you are coding a "frequencies.txt" yourselve please mind the syntax as wrong syntaxes can lead to the <i>oszillatron</i> crashing and possibly taking your computer with it!</p>
