# AGENTS.md — PsCanvas Classic Project Rules

This file applies to every AI coding agent, code assistant, and automated session. It contains only durable constraints, phase gates, and workspace protections. Current progress, one-off evidence, detailed API plans, and feature designs belong in their authoritative documents.

## 1. Authority and document ownership

Resolve conflicts in this order:

1. The user's latest explicit decision.
2. Durable rules in this file.
3. Phase order and TODO status in `../change/00_PsCanvasClassic_下一阶段执行总纲与TODO_20260916.md`.
4. Hook semantics, composite gates, and cutover order in `../change/P1_PsCanvasClassic_Hook迁移清单_20260916.md`.
5. Baseline, backup, and verification evidence in `../change/P0_PsCanvasClassic_重构前基线与回退记录_20260916.md`.
6. Implementation details in `../change/PsCanvasClassic_现代化重构与标准化实施方案.md` and the `../change/01` through `04` feature documents.

When the user changes a durable decision, update this file and remove the conflicting rule. Do not leave an exception only in a temporary task note.

Only the progress section of document `00` determines the current gate and completion state. A successful build does not authorize crossing a gate. Do not duplicate phase snapshots in this file.

## 2. Durable project invariants

- The formal project and display name is **PsCanvas Classic**, and the target component is `com.oplus.pscanvas`.
- Preserve `applicationId` `com.color.pscanvasfix` and the existing signing continuity so installed builds, LSPosed enablement, scope, and configuration remain upgrade-compatible.
- The source uses the custom **PsCanvas Classic Standalone Source License**. It permits viewing, downloading, cloning, forking, modifying, compiling, installing, running, testing, and compliant distribution as a standalone PsCanvas Classic project or application. Without prior explicit written authorization, Covered Materials may not be copied, ported, merged, embedded, bundled, or otherwise incorporated into another application, module, framework, toolkit, service, or multi-function project. Keep `LICENSE` and user-facing notices consistent with this standalone-use boundary.
- The target architecture is the official modern libxposed API. Existing legacy entry points, APIs, and transitional names may remain until their planned migration; do not use them as a reason for an unplanned global rewrite.
- Compatibility must be capability-driven and structure-driven. SHA-256, versionDate, versionName, versionCode, and internal generation labels are diagnostic, logging, testing, and research data only. They must not gate capability installation.
- The 251215 (original 502) build is a static oracle for classic behavior only. Do not require installing or running it on a newer system. Mark visual details that cannot be established statically as `UNVERIFIED`.
- For three-task letterboxing, the first diagnostic invariant is:

```text
canvas slot proportions = TaskData LaunchBounds = actual WM task bounds
```

If these layers differ, trace rectangle propagation before investigating View backgrounds, Surface refreshes, or delays.

## 3. Modern architecture and call semantics

### 3.1 Layer boundaries

- After the modern cutover, only the `module/` and `runtime/` infrastructure layers may depend directly on `io.github.libxposed.api`.
- The `feature/`, `resolver/`, `compat/`, and `diagnostic/` layers must use project-owned boundaries for hooks, reflection, instance state, and logging.
- Phase 1 only consolidates shared facilities such as `ReflectionAccess`, `InstanceStateStore`, `ModuleLogger`, and `HookRegistry`. Do not expand legacy Xposed dependencies.
- Use the modern framework API as `compileOnly`; do not package it into the APK.
- The default scope is only `com.oplus.pscanvas`. Do not expand it to other apps, SystemUI, or system_server without evidence from the call chain and an explicit user decision.

### 3.2 Original calls and argument semantics

- Calling the OEM origin (`ORIGIN`) and continuing the interceptor chain (`PROCEED`) are different operations. Never mechanically replace legacy `invokeOriginalMethod()` with `chain.proceed()`.
- Argument rewriting must copy and explicitly pass the new arguments. Do not assume modern hook arguments are mutable in place.
- For every migrated hook, preserve its before/after/replace mode, ORIGIN/PROCEED choice, short-circuit return, and exception semantics in the P1 inventory.
- When call semantics are uncertain, check current official libxposed Javadoc/source, the official example, and the existing call chain. Do not infer them from memory or old third-party material.

## 4. Resolver, naming, and hook installation

- Resolve capabilities in this order: identify structural role, resolve method, score/verify, install feature. Unknown versions must still run structural resolution.
- A feature with one independent role may degrade independently. If a feature is declared an atomic combination, any missing required role skips the entire combination.
- Preserve `THREE_SPLIT_ANIM && THREE_SPLIT_DRAG` as an atomic composite gate.
- Obfuscated short names may appear only in `KnownSymbolHints`, resolver fallbacks, test fixtures, and research documents. Features must not introduce hard-coded obfuscated class or method names.
- Name production classes and methods by behavior. Do not add implementations named after internal generations such as `251215`, `502`, or `260xxx`.
- Every feature must declare its required roles and isolate capability failures. Record the feature, method, and exception when installation fails; unrelated capabilities must continue independently.
- Hook hot paths must not scan DEX files or perform broad reflection. Resolve once per target process and cache the result.
- Register every active hook with a stable hook ID, installation result, and diagnostic state. Migrating a helper must not activate dormant legacy hooks.
- Keep both Android-log and framework-log sinks. “Hook installed” proves installation only, not correct behavior.

## 5. Migration freeze and phase gates

During framework migration, directory work, and naming cleanup, do not opportunistically change:

- the target three-task layout or letterbox fix chain;
- TaskData, LaunchBounds, and WM-bounds synchronization;
- current Panorama entry and exit behavior;
- the five-finger gesture state machine or animation parameters;
- existing OEM two-task behavior.

Phase constraints:

- Before M1 completes, perform only behavior-equivalent Reflection, State, Logging, and HookRegistry consolidation. Do not implement new split-screen behavior.
- Before entering M2, freeze the P1 active-hook inventory and composite gates, capture the pending P0 pre-migration device behavior baseline, and create a recoverable checkpoint of current work.
- During the M2 cutover, switch all active hooks at once in the existing `install()` order. Do not create a mixed active legacy/modern runtime, and do not include UI, renaming, or feature behavior changes.
- TwoTask Panorama and Resize work may proceed only after M3 and M4, following document `00`. Four Task product work is discontinued and is not a future phase.

Development batches group implementation and review work only; they do not authorize partial activation of modern hooks.

## 6. Verification and evidence

### 6.1 Change workflow

Before editing:

1. Read this file and the authoritative document for the task.
2. Inspect the current branch, `git status`, and target-file diffs.
3. State the files, rationale, current gate, and behaviors that must remain unchanged.
4. Select the smallest verifiable slice.

After editing:

1. Run focused tests proportional to the risk.
2. For framework/API refactors, run at least `gradlew test assembleDebug assembleRelease`.
3. Run the offline resolver regression when an APK archive is available.
4. Check targeted call counts, APK metadata when applicable, and `git diff --check`.
5. Report the commands actually run, results, diff summary, and unverified items.

### 6.2 Evidence layers

- Unit tests, offline APK regressions, builds, installation, module loading, hook hits, and on-device behavior are separate evidence layers. Report them separately.
- A successful build or install does not prove two-task, three-task, Panorama, split-bar, or bounds behavior.
- UI, gesture, and window behavior require observation on a real target device. Without device evidence, report them as `NOT VERIFIED`.
- Never invent command output, build/test success, API availability, or device results.
- After two failed fixes for the same issue, stop stacking hooks. Recheck the call chain, resolver output, actual hook hits, OEM origin results, and recent diffs.

## 7. Shared workspace, Git, and commit protection

- Treat every existing workspace modification as user or peer-agent work. Do not revert, overwrite, or reformat unrelated files.
- Assign agents non-overlapping file sets. The primary agent integrates and verifies any file that would otherwise be shared.
- In a dirty worktree, do not run pull, rebase, merge, checkout, stash, reset, or clean until the primary agent has verified the change set, conflict surface, and recovery plan.
- For scoped work, stage only explicit files or hunks. Never use broad staging such as `git add .` or `git add -A`.
- Before committing, inspect staged paths, run `git diff --cached --check`, and inspect remaining unstaged work.
- Do not use `git reset --hard`, `git clean -fd`, or delete archives, reverse-engineering material, signing material, or baseline APKs.
- Keep framework, resolver, directory/naming, UI, behavior fixes, and new features in separate commits so each remains reversible and bisectable.
- Build outputs are not source changes, but do not clean away baseline artifacts that have not been recorded.
- The outer `../change/` directory and the inner Git repository are separate boundaries. Backup, commit, and status reports must state which boundary they cover.

## 8. UI, identity, and release

- Perform UI work only after the modern trunk is stable, in changes separate from the cutover and business features.
- Use the LSPosed manager only as a reference for Material 3 buttons, setting rows, status cards, and light/dark design language. Do not copy its brand, assets, or full information architecture.
- Use `../change/logo.png` as the design source for later launcher, adaptive, and monochrome icon assets.
- Do not bundle unrelated AGP, Gradle, DSL, or JDK upgrades into migration work. Every dependency or toolchain change must serve the current gate and be explained separately.
- The identity decision is fixed for the current modernization: display name `PsCanvas Classic`, application ID `com.color.pscanvasfix`, existing signing continuity, and the custom standalone-source license in `LICENSE`. Never commit keystores, private keys, or passwords.
- Keep README user-facing and concise. Public README and release notes use only formal release versions, not internal generation labels or extensive reverse-engineering detail.
- Show README and release content to the user for confirmation before publishing.

## 9. New feature boundaries

Implement new features only in the order defined by document `00` and feature documents `01` through `04`, with separate feature classes, commits, and regressions:

- `TwoTaskPanoramaFeature`: reuse a verified OEM Panorama entry, exit, and restore path. Do not mechanically change `taskCount == 3` to `>= 2`.
- Four Task product implementation is discontinued. Keep its product entry hidden. Preserve existing preference, capability, diagnostics, trace, tests, and research material only as historical evidence; do not resume Four Task work or expose its entry unless the user explicitly reverses this decision.
- Treat saved-layout topology and the exact visible viewport as separate acceptance layers. Restoring divider ratios, slot topology, and shortcut payload does not prove that canvas translation or visible focus matches the instant of saving; claim the latter only with dedicated device evidence.
- Adjacent-window Resize: continuously preserve equality between canvas slots, TaskData LaunchBounds, and WM bounds.
- Do not implement four-task capacity, append, layout, WM commit, Panorama, or product behavior. Existing P4 trace and resolver code remains dormant historical research, not an active TODO.

User-configurable enhancements use `Preference AND Capability` and fail closed. A foundational feature that is not designed as a user setting uses only Capability and its own behavior gates; do not invent a setting for it.

## 10. Maintaining this file

- Keep only durable rules, phase gates, and workspace protection here. Do not add test counts, build hashes, one-off logs, or current file lists.
- Write API details, hook IDs, phase status, and feature implementation notes back to their authoritative documents.
- When editing this file, remove stale and duplicate rules so old and new constraints do not coexist.
- Verify official documentation before changing rules for a new API version.
