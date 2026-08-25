# PsCanvasFix 260608 Compatibility Design

## Purpose

Restore the existing v1.0 behavior on the known ColorOS PsCanvas APK while
making future vendor APK changes safe and diagnosable:

- Three-app panorama layout instead of 700's equal-width three-column layout.
- Four-finger pinch transition to a floating window.
- No unsafe hook installation when the vendor APK is unknown.

This work explicitly excludes the 4-6 application split-screen roadmap and
any rewrite of the established 502 behavior in the compatibility classes.

## Evidence and supported baseline

The target device `192.168.5.14:40005` runs the same APK as the supplied
reference file:

| Property | Value |
| --- | --- |
| Package | `com.oplus.pscanvas` |
| Version | `versionCode=20`, `versionName=2.0.0` |
| Baseline date | `260608` |
| SHA-256 | `1cbf75ee66565ba4eb2e78c360243bc97d7e13379595f94914af5b25c7a77fe3` |

`versionName` is not a compatibility key: the previous 260403 and target
260608 APKs both report `2.0.0` while their obfuscated symbols differ.

## Architecture

Introduce an immutable compatibility profile selected before application
hooks are installed. A profile is responsible only for describing the target
APK's semantic roles and verified method mappings. Existing `*Compat` classes
retain the 502 behavior; `PsCanvasHooks` continues to orchestrate installation
but obtains all target symbols through the selected profile.

The initial profile is `260608` and has these verified role mappings:

| Semantic role | 260403 symbol | 260608 symbol |
| --- | --- | --- |
| SStoFlexible | `x1.r` | `x1.x` |
| ThreeSplitAnim | `x1.x` | `x1.D` |
| ThreeSplitDrag | `x1.y` | `x1.E` |
| CanvasController | `canvas.r0` | `canvas.s0` |

Verified SStoFlexible method mappings are `f0 -> t0`, `B -> H`, `C -> I`, and
`S -> Z`. Methods whose short names or semantics are not yet proven are not
remapped speculatively. Their hook group is skipped with an explicit reason.

## Installation and failure behavior

On loading `com.oplus.pscanvas`, the module calculates the SHA-256 of the
installed `base.apk` once and selects a matching profile.

1. A matching profile resolves classes and methods by semantic role.
2. Hooks install as independent groups: base layout, pinch-to-floating-window,
   three-split animation suppression, and split-bar drag suppression.
3. A missing target disables only its group and dependent groups.
4. An unknown APK installs no high-risk hooks and leaves PsCanvas native.

The module emits a compact diagnostic summary containing the APK identity,
selected profile, class-resolution result, and `installed`, `skipped`, or
`failed` status for each hook group. A final generic success line alone is not
considered proof of compatibility.

## Update workflow

Each vendor update follows this controlled path:

1. Extract the new installed `base.apk` and record its SHA-256.
2. Diff its symbols and method bodies against the latest supported profile.
3. Add a new profile only for role and method mappings confirmed by signatures,
   field usage, callers, and runtime logs.
4. Build and install the module on the target device.
5. Verify the diagnostic summary, panorama layout, and four-finger pinch flow.

Existing profiles are retained, so supporting a later APK does not alter the
known 260608 behavior.

## Verification

- Unit tests cover profile selection, unknown-APK safe fallback, and hook-group
  dependency handling.
- A debug build must complete successfully.
- Device testing installs the debug module, clears and captures logs, then
  manually validates panorama three-split and four-finger pinch behavior.
- Acceptance logs must show a matching 260608 profile and successful status
  for every required group; skipped or failed required groups block release.

## Non-goals

- Guaranteed behavior on an APK not represented by a verified profile.
- Automatic inference of changed short-name methods without analysis.
- Changes to the vendor APK or to Android system services.
- Expansion from three to four or more split applications.
